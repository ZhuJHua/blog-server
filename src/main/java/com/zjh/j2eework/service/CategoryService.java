package com.zjh.j2eework.service;

import com.zjh.j2eework.entity.Category;
import com.zjh.j2eework.pojo.Result;

import java.util.List;
import java.util.Optional;

/**
 * @Description Category接口
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/23
 */
public interface CategoryService {
    Category addCategory(Category category);
    
    void delCategory(Long id);
    
    List<Category> findAllCategory();
    
    Category updateCategory(Category category);
    
    Optional<Category> findByCategoryName(String name);
}
