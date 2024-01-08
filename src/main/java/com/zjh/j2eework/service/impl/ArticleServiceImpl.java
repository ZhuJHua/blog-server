package com.zjh.j2eework.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjh.j2eework.dao.mapper.ArticleMapper;
import com.zjh.j2eework.entity.Article;
import com.zjh.j2eework.service.ArticleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @Description Article service
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/23
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
    
    private final ArticleMapper articleMapper;
    //敏感词检测Service
    private final SensitiveServiceImpl sensitiveService;
    //全文搜索Service
    private final ElasticServiceImpl elasticService;
    private final CategoryServiceImpl categoryService;
    private final UserServiceImpl userService;
    
    public ArticleServiceImpl(SensitiveServiceImpl sensitiveService,
                              ElasticServiceImpl elasticService, ArticleMapper articleMapper,
                              CategoryServiceImpl categoryService, UserServiceImpl userService) {
        this.sensitiveService = sensitiveService;
        this.elasticService = elasticService;
        this.articleMapper = articleMapper;
        this.categoryService = categoryService;
        this.userService = userService;
    }
    
    @Override
    @Transactional
    public Article addArticle(Article article) {
        //文章写入到MySQL
        articleMapper.saveArticle(article);
        //文章写入到es
        elasticService.saveToElasticSearch(article);
        return article;
    }
    
    @Override
    @Transactional
    public void delArticle(Long id) {
        //删除MySQL中的文章
        removeById(id);
        articleMapper.deleteById(id);
        //删除es中的文章
        elasticService.delElasticSearch(id);
    }
    
    @Override
    public List<Article> findAllArticle() {
        return articleMapper.selectListWithUserAndCategory();
    }
    
    @Override
    @Transactional
    public Article updateArticle(Article article) {
        //更新newArticle中的文章
        updateById(article);
        //更新es中的文章
        elasticService.updateElasticSearch(article);
        return article;
    }
    
    @Override
    public Optional<Article> findArticleById(Long id) {
        return Optional.ofNullable(getById(id));
    }
    
    @Override
    public void updateViews(Long id) {
        articleMapper.updateViews(id);
    }
    
    @Override
    public boolean checkArticle(String content) {
        return sensitiveService.containsSensitiveWord(content);
    }
    
    @Override
    @Transactional
    public void flushElastic() {
        //从数据库中获取最新的article
        List<Article> articleList = list();
        //删除es中所有数据
        elasticService.delAllArticle();
        //遍历list写入es
        articleList.forEach(elasticService::saveToElasticSearch);
    }
    
}
