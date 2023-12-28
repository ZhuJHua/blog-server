package com.zjh.j2eework.dao.jpa;

import com.zjh.j2eework.entity.SensitiveWord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @Description 铭感词 Jpa接口
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/28
 */
@Repository
public interface JpaSensitiveRepository extends JpaRepository<SensitiveWord, Long> {
    @Query("SELECT DISTINCT a.sensitiveWord FROM SensitiveWord a")
    Set<String> findAllDistinctContents();
    
    @Transactional
    @Modifying
    @Query("DELETE FROM SensitiveWord s WHERE s.sensitiveWord=:sensitiveWord")
    void deleteSensitiveWord(String sensitiveWord);
}
