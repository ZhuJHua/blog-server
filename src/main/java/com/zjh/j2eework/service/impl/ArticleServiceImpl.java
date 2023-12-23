package com.zjh.j2eework.service.impl;

import com.zjh.j2eework.dao.JpaArticleRepository;
import com.zjh.j2eework.entity.Article;
import com.zjh.j2eework.pojo.Result;
import com.zjh.j2eework.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Result addArticle(Article article) {
        return null;
    }
    
    @Override
    public Result delArticle(Long id) {
        return null;
    }
    
    @Override
    public Result findAllArticle() {
        return null;
    }
    
    @Override
    public Result updateArticle(Article article) {
        return null;
    }
}
