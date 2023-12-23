package com.zjh.j2eework.service;

import com.zjh.j2eework.entity.Category;
import com.zjh.j2eework.pojo.Result;

/**
 * @Description Category接口
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/23
 */
public interface CategoryService {
    Result addCategory(Category category);
    
    Result delCategory(Long id);
    
    Result findAllCategory();
    
    Result updateCategory(Category category);
}
