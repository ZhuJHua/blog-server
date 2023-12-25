package com.zjh.j2eework.dao;

import com.zjh.j2eework.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Description 用户Jpa接口
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/23
 */
@Repository
public interface JpaUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    
    long deleteByUsername(String username);
}
