package com.zjh.j2eework.service.impl;

import com.zjh.j2eework.dao.JpaArticleRepository;
import com.zjh.j2eework.entity.Article;
import com.zjh.j2eework.service.ArticleService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Description Article service
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/23
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    private final JpaArticleRepository jpaArticleRepository;
    
    public ArticleServiceImpl(JpaArticleRepository jpaArticleRepository) {
        this.jpaArticleRepository = jpaArticleRepository;
        
    }
    
    @Override
    public Article addArticle(Article article) {
        return jpaArticleRepository.save(article);
    }
    
    @Override
    public void delArticle(Long id) {
        jpaArticleRepository.deleteById(id);
    }
    
    @Override
    public List<Article> findAllArticle() {
        return jpaArticleRepository.findAll(Sort.by("postTime").descending());
    }
    
    @Override
    public Article updateArticle(Article article) {
        return jpaArticleRepository.save(article);
    }
    
    @Override
    public Optional<Article> findArticleById(Long id) {
        return jpaArticleRepository.findById(id);
    }
    
    @Override
    public void updateViews(Long id) {
        jpaArticleRepository.incrementViewCount(id);
    }
    
}
