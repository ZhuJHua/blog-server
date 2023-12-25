package com.zjh.j2eework.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.zjh.j2eework.entity.User;
import com.zjh.j2eework.pojo.Result;
import com.zjh.j2eework.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.zjh.j2eework.util.HttpCode.BAD_REQUEST;
import static com.zjh.j2eework.util.HttpCode.OK;

/**
 * @Description User control
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/23
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {
    private final UserServiceImpl userService;
    
    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
    
    /**
     * 登录
     */
    @PostMapping("/login")
    public Result doLogin(@RequestBody User user) {
        
        return userService.findUserByName(user.getUsername()).map(u -> {
            if (user.getPassword().equals(u.getPassword())) {
                StpUtil.login(user.getUsername());
                return new Result(OK.getCode(), OK.getDescription(), StpUtil.getTokenInfo());
            } else {
                return new Result(BAD_REQUEST.getCode(), "用户名或密码错误", "");
            }
        }).orElse(new Result(BAD_REQUEST.getCode(), "用户不存在", ""));
        
    }
    
}
