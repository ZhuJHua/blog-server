package com.zjh.j2eework.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjh.j2eework.dao.mapper.CategoryMapper;
import com.zjh.j2eework.entity.Category;
import com.zjh.j2eework.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Description Category service
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/23
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    private final CategoryMapper categoryMapper;
    
    public CategoryServiceImpl(CategoryMapper categoryMapper) {
        
        this.categoryMapper = categoryMapper;
    }
    
    @Override
    public Category addCategory(Category category) {
        save(category);
        return category;
    }
    
    @Override
    public void delCategory(Long id) {
        removeById(id);
    }
    
    @Override
    public List<Category> findAllCategory() {
        return list();
    }
    
    @Override
    public Category updateCategory(Category category) {
        updateById(category);
        return category;
    }
    
    @Override
    public Optional<Category> findByCategoryName(String name) {
        //根据姓名 查询
        return Optional.ofNullable(categoryMapper.findCategoryByName(name));
    }
    
    @Override
    public Category findCategoryById(Long id) {
        return getById(id);
    }
}
