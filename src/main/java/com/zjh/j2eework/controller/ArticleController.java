package com.zjh.j2eework.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaIgnore;
import com.zjh.j2eework.entity.Article;
import com.zjh.j2eework.pojo.Result;
import com.zjh.j2eework.service.impl.ArticleServiceImpl;
import org.springframework.web.bind.annotation.*;

import static com.zjh.j2eework.util.HttpCode.BAD_REQUEST;
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
     * 获取文章
     */
    @GetMapping
    @SaIgnore
    public Result getArticle(@RequestParam(required = false, name = "id") Long id) {
        return id != null ? articleService.findArticleById(id).map(article -> new Result(OK.getCode(),
                        OK.getDescription(), article))
                .orElse(new Result(BAD_REQUEST.getCode(), "文章不存在", "")) :
                new Result(OK.getCode(), OK.getDescription(), articleService.findAllArticle());
    }
    
    /**
     * 获取指定用户的文章
     */
    
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
    @SaIgnore
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
    
    /**
     * 更新view
     */
    @GetMapping("/view")
    @SaIgnore
    public Result updateView(@RequestParam(name = "id") Long id) {
        articleService.updateViews(id);
        return new Result(OK.getCode(), OK.getDescription(), "");
    }
}
