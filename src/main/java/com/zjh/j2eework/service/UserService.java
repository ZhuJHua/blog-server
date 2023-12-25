package com.zjh.j2eework.service;

import com.zjh.j2eework.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * @Description User接口
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/23
 */
public interface UserService {
    User addUser(User user);
    
    void delUser(String username);
    
    List<User> findAllUser();
    
    User updateUser(User user);
    
    Optional<User> findUserByName(String username);
}
