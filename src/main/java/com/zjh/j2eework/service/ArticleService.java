package com.zjh.j2eework.service;

import com.zjh.j2eework.entity.Article;

import java.util.List;
import java.util.Optional;

/**
 * @Description Article接口
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/23
 */
public interface ArticleService {
    Article addArticle(Article article);
    
    void delArticle(Long id);
    
    List<Article> findAllArticle();
    
    Article updateArticle(Article article);
    
    Optional<Article> findArticleById(Long id);
    
    void updateViews(Long id);
    
    boolean checkArticle(String content);
    
    void flushElastic();
}
