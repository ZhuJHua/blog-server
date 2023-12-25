package com.zjh.j2eework.service.impl;

import com.zjh.j2eework.dao.JpaUserRepository;
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
public class UserServiceImpl implements UserService {
    private final JpaUserRepository jpaUserRepository;
    
    public UserServiceImpl(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }
    
    @Override
    public User addUser(User user) {
        return jpaUserRepository.save(user);
    }
    
    @Override
    public void delUser(String username) {
        jpaUserRepository.deleteByUsername(username);
    }
    
    @Override
    public List<User> findAllUser() {
        return jpaUserRepository.findAll();
    }
    
    @Override
    public User updateUser(User user) {
        return jpaUserRepository.save(user);
    }
    
    @Override
    public Optional<User> findUserByName(String username) {
        return jpaUserRepository.findByUsername(username);
    }
}
