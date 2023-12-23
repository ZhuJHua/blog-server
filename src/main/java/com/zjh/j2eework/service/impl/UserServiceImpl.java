package com.zjh.j2eework.service.impl;

import com.zjh.j2eework.dao.JpaUserRepository;
import com.zjh.j2eework.entity.User;
import com.zjh.j2eework.pojo.Result;
import com.zjh.j2eework.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Description User service
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/23
 */
@Service
public class UserServiceImpl implements UserService {
    private final JpaUserRepository jpaUserRepository;
    
    public UserServiceImpl(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }
    
    @Override
    public Result addUser(User user) {
        return null;
    }
    
    @Override
    public Result delUser(Long id) {
        return null;
    }
    
    @Override
    public Result findAllUser() {
        return null;
    }
    
    @Override
    public Result updateUser(User user) {
        return null;
    }
}
