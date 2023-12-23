package com.zjh.j2eework.service.impl;

import com.zjh.j2eework.dao.JpaCategoryRepository;
import com.zjh.j2eework.entity.Category;
import com.zjh.j2eework.pojo.Result;
import com.zjh.j2eework.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * @Description Category service
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/23
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    private final JpaCategoryRepository jpaCategoryRepository;
    
    public CategoryServiceImpl(JpaCategoryRepository jpaCategoryRepository) {
        this.jpaCategoryRepository = jpaCategoryRepository;
    }
    
    @Override
    public Result addCategory(Category category) {
        return null;
    }
    
    @Override
    public Result delCategory(Long id) {
        return null;
    }
    
    @Override
    public Result findAllCategory() {
        return null;
    }
    
    @Override
    public Result updateCategory(Category category) {
        return null;
    }
}
