package com.zjh.j2eework.controller;

import com.zjh.j2eework.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }
}
