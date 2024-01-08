package com.zjh.j2eework.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.annotation.SaIgnore;
import com.zjh.j2eework.pojo.Result;
import com.zjh.j2eework.service.impl.ElasticServiceImpl;
import com.zjh.j2eework.util.HttpCode;
import org.springframework.web.bind.annotation.*;

/**
 * @Description es搜索
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/29
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/search")
public class EsController {
    private final ElasticServiceImpl elasticService;
    
    public EsController(ElasticServiceImpl elasticService) {
        this.elasticService = elasticService;
    }
    
    @GetMapping
    @SaIgnore
    public Result searchKeyword(@RequestParam(name = "id") String word) {
        return new Result(HttpCode.OK.getCode(), HttpCode.OK.getDescription(), elasticService.findByContent(word));
    }
    
    @DeleteMapping
    @SaCheckLogin
    public void delAllArticle(){
        elasticService.delAllArticle();
    }
}
