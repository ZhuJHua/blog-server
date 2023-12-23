package com.zjh.j2eework.controller;

import com.zjh.j2eework.service.impl.ArticleServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description Article control
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/23
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/article")
public class ArticleController {
    private final ArticleServiceImpl articleService;
    
    public ArticleController(ArticleServiceImpl articleService) {
        this.articleService = articleService;
    }
}