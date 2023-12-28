package com.zjh.j2eework.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import com.zjh.j2eework.entity.SensitiveWord;
import com.zjh.j2eework.pojo.Result;
import com.zjh.j2eework.service.impl.SensitiveServiceImpl;
import com.zjh.j2eework.util.HttpCode;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 敏感词 Controller
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/28
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/sensitive")
public class SensitiveController {
    private final SensitiveServiceImpl sensitiveService;
    
    public SensitiveController(SensitiveServiceImpl sensitiveService) {
        this.sensitiveService = sensitiveService;
    }
    
    @PostMapping
    @SaCheckLogin
    public Result addSensitiveWord(@RequestBody SensitiveWord sensitive) {
        sensitiveService.addSensitive(sensitive);
        return new Result(HttpCode.OK.getCode(), "添加成功", "");
    }
    
    @DeleteMapping()
    @SaCheckLogin
    public Result delSensitiveWord(@RequestParam(name = "id") String id) {
        sensitiveService.delSensitive(id);
        return new Result(HttpCode.OK.getCode(), "删除成功", "");
    }
    
    @GetMapping
    @SaCheckLogin
    public Result getSensitiveWord() {
        return new Result(HttpCode.OK.getCode(), HttpCode.OK.getDescription(), sensitiveService.getWordList());
    }
}
