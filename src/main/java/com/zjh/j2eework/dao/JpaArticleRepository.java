package com.zjh.j2eework.dao;

import com.zjh.j2eework.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description 文章Jpa接口
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/23
 */
@Repository
public interface JpaArticleRepository extends JpaRepository<Article, Long> {
    
    @Transactional
    @Modifying
    @Query("UPDATE Article a SET a.view = a.view + 1 WHERE a.id = :articleId")
    void incrementViewCount(Long articleId);
    
}
