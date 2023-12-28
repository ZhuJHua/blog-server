package com.zjh.j2eework.service.impl;

import com.zjh.j2eework.dao.jpa.JpaArticleRepository;
import com.zjh.j2eework.entity.Article;
import com.zjh.j2eework.service.ArticleService;
import org.springframework.data.domain.Sort;
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
public class ArticleServiceImpl implements ArticleService {
    
    //article dao
    private final JpaArticleRepository jpaArticleRepository;
    //敏感词检测Service
    private final SensitiveServiceImpl sensitiveService;
    //全文搜索Service
    private final ElasticServiceImpl elasticService;
    
    public ArticleServiceImpl(JpaArticleRepository jpaArticleRepository, SensitiveServiceImpl sensitiveService,
                              ElasticServiceImpl elasticService) {
        this.jpaArticleRepository = jpaArticleRepository;
        this.sensitiveService = sensitiveService;
        this.elasticService = elasticService;
    }
    
    @Override
    @Transactional
    public Article addArticle(Article article) {
        //文章写入到MySQL
        Article savedArticle = jpaArticleRepository.save(article);
        //文章写入到es
        elasticService.saveToElasticSearch(article);
        return savedArticle;
    }
    
    @Override
    @Transactional
    public void delArticle(Long id) {
        //删除MySQL中的文章
        jpaArticleRepository.deleteById(id);
        //删除es中的文章
        elasticService.delElasticSearch(id);
    }
    
    @Override
    public List<Article> findAllArticle() {
        return jpaArticleRepository.findAll(Sort.by("postTime").descending());
    }
    
    @Override
    @Transactional
    public Article updateArticle(Article article) {
        //更新newArticle中的文章
        Article newArticle = jpaArticleRepository.save(article);
        //更新es中的文章
        elasticService.updateElasticSearch(article);
        return newArticle;
    }
    
    @Override
    public Optional<Article> findArticleById(Long id) {
        return jpaArticleRepository.findById(id);
    }
    
    @Override
    public void updateViews(Long id) {
        jpaArticleRepository.incrementViewCount(id);
    }
    
    @Override
    public boolean checkArticle(String content) {
        return sensitiveService.containsSensitiveWord(content);
    }
    
    @Override
    public void saveElastic(Article article) {
    
    }
    
}
