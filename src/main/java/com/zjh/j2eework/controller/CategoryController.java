package com.zjh.j2eework.controller;

import com.zjh.j2eework.service.impl.CategoryServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description Category control
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/23
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/category")
public class CategoryController {
    private final CategoryServiceImpl categoryService;
    
    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }
}
