package com.zjh.j2eework.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.zjh.j2eework.entity.Article;
import com.zjh.j2eework.pojo.Result;
import com.zjh.j2eework.service.impl.ArticleServiceImpl;
import org.springframework.web.bind.annotation.*;

import static com.zjh.j2eework.util.HttpCode.OK;

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
    
    /**
     * 获取全部文章
     */
    @GetMapping
    public Result getArticle() {
        return new Result(OK.getCode(), OK.getDescription(), articleService.findAllArticle());
    }
    
    /**
     * 删除文章
     */
    @DeleteMapping
    @SaCheckLogin
    public Result delArticle(@RequestParam(name = "id") Long id) {
        articleService.delArticle(id);
        return new Result(OK.getCode(), OK.getDescription(), "");
    }
    
    /**
     * 增加文章
     */
    @PostMapping
    @SaCheckLogin
    public Result addArticle(@RequestBody Article article) {
        return new Result(OK.getCode(), OK.getDescription(), articleService.addArticle(article));
    }
    
    /**
     * 修改文章
     */
    @PutMapping
    @SaCheckLogin
    public Result updateArticle(@RequestBody Article article) {
        return new Result(OK.getCode(), OK.getDescription(), articleService.updateArticle(article));
    }
}
