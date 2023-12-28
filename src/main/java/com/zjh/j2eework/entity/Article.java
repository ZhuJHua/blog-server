package com.zjh.j2eework.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @Description 文章
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/23
 */
@Entity
@Document(indexName = "article")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aid", nullable = false)
    private Long id;
    
    @Column(name = "title")
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title;
    
    @Column(name = "content", columnDefinition = "text")
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String content;
    
    @Column(name = "post_time")
    private Long postTime;
    
    @Column(name = "tag")
    private String tag;
    
    @Column(name = "view")
    private Long view;
    
    @ManyToOne
    @JoinColumn(name = "user_uid")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "category_cid")
    private Category category;
    
}
