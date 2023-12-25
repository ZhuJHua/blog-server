package com.zjh.j2eework.service.impl;

import com.zjh.j2eework.dao.JpaCategoryRepository;
import com.zjh.j2eework.entity.Category;
import com.zjh.j2eework.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Category addCategory(Category category) {
        return jpaCategoryRepository.save(category);
    }
    
    @Override
    public void delCategory(Long id) {
        jpaCategoryRepository.deleteById(id);
    }
    
    @Override
    public List<Category> findAllCategory() {
        return jpaCategoryRepository.findAll();
    }
    
    @Override
    public Category updateCategory(Category category) {
        return jpaCategoryRepository.save(category);
    }
}
