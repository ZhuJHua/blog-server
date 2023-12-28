package com.zjh.j2eework.dao.es;

import com.zjh.j2eework.entity.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @Description 文章搜索
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/29
 */
public interface ElasticSearchRepository extends ElasticsearchRepository<Article, Long> {
    List<Article> findByContent(String content);
    
    List<Article> findByTitle(String title);
}
