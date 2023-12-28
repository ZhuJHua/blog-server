package com.zjh.j2eework.service;

import com.zjh.j2eework.entity.Article;

import java.util.List;

/**
 * @Description Elastic 接口
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/29
 */
public interface ElasticService {
    void saveToElasticSearch(Article article);
    void delElasticSearch(Long id);
    void updateElasticSearch(Article article);
    
    List<Article> findByContent(String content);
    List<Article> findByTitle(String title);
}
