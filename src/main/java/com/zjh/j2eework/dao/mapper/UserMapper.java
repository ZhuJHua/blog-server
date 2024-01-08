package com.zjh.j2eework.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjh.j2eework.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Description
 * @Author 住京华 www.zhujinghua.com
 * @Date 2024/1/8
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    
    @Delete("delete from user where username=#{name}")
    void delUser(String name);
    
    @Select("select * from user where username=#{name}")
    User getUser(String name);
}
