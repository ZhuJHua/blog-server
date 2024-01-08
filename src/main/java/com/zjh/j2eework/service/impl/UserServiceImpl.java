package com.zjh.j2eework.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjh.j2eework.dao.mapper.UserMapper;
import com.zjh.j2eework.entity.User;
import com.zjh.j2eework.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Description User service
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private final UserMapper userMapper;
    
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
        
    }
    
    @Override
    public User addUser(User user) {
        save(user);
        return user;
    }
    
    @Override
    public void delUser(String username) {
        userMapper.delUser(username);
    }
    
    @Override
    public List<User> findAllUser() {
        return list();
    }
    
    @Override
    public User updateUser(User user) {
        updateById(user);
        return user;
    }
    
    @Override
    public Optional<User> findUserByName(String username) {
        
        return Optional.ofNullable(userMapper.getUser(username));
    }
    
    @Override
    public User findUserById(Long id) {
        return getById(id);
    }
}
