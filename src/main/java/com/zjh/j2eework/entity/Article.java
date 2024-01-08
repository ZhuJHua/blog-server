package com.zjh.j2eework.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.JdbcType;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @Description 文章
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/23
 */
@TableName("article")
@Document(indexName = "article")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Article {
    @TableId(type = IdType.AUTO, value = "aid")
    private Long id;
    
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title;
    
    @TableField(value = "content", jdbcType = JdbcType.LONGVARCHAR)
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String content;
    
    @TableField(value = "post_time")
    private Long postTime;
    
    @TableField(value = "tag")
    private String tag;
    
    @TableField(value = "view")
    private Long view;
    
    @TableField(value = "user_uid",exist = false)
    private User user;
    
    @TableField(value = "category_cid",exist = false)
    private Category category;
    
}
