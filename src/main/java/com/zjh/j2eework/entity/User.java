package com.zjh.j2eework.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description 用户
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/23
 */
@TableName("user")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class User {
    @TableId(type = IdType.AUTO, value = "uid")
    private Long id;
    
    @TableField(value = "username")
    private String username;
    
    @TableField(value = "password")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    
    @TableField(value = "auth")
    @JsonIgnore
    private Integer auth;
    
}
