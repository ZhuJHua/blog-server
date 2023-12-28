package com.zjh.j2eework.dao.jpa;

import com.zjh.j2eework.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Description 分类Jpa接口
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/23
 */
@Repository
public interface JpaCategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByCategoryName(String categoryName);
}
