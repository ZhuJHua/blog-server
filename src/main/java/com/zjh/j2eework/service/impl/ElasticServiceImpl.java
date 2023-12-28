package com.zjh.j2eework.service.impl;

import com.zjh.j2eework.dao.es.ElasticSearchRepository;
import com.zjh.j2eework.entity.Article;
import com.zjh.j2eework.service.ElasticService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description elastic service
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/29
 */
@Service
public class ElasticServiceImpl implements ElasticService {
    private final ElasticSearchRepository elasticSearchRepository;
    
    public ElasticServiceImpl(ElasticSearchRepository elasticSearchRepository) {
        this.elasticSearchRepository = elasticSearchRepository;
    }
    
    @Override
    public void saveToElasticSearch(Article article) {
        elasticSearchRepository.save(article);
    }
    
    @Override
    public void delElasticSearch(Long id) {
        elasticSearchRepository.deleteById(id);
    }
    
    @Override
    public void updateElasticSearch(Article article) {
        elasticSearchRepository.save(article);
    }
    
    @Override
    public List<Article> findByContent(String content) {
        
        return elasticSearchRepository.findByContent(content);
    }
    
    @Override
    public List<Article> findByTitle(String title) {
        return elasticSearchRepository.findByTitle(title);
    }
}
