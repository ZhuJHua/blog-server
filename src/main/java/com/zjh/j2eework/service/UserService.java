package com.zjh.j2eework.service;

import com.zjh.j2eework.entity.User;
import com.zjh.j2eework.pojo.Result;

/**
 * @Description User接口
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/23
 */
public interface UserService {
    Result addUser(User user);
    
    Result delUser(Long id);
    
    Result findAllUser();
    
    Result updateUser(User user);
}
