package com.zjh.j2eework.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description 分类
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/23
 */
@TableName("category")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Category {
    @TableId(type = IdType.AUTO,value = "cid")
    private Long id;
    
    @TableField(value = "category_name")
    private String categoryName;
    
}
