package com.zjh.j2eework.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 分类
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/23
 */
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid", nullable = false)
    private Long id;
    
    @Column(name = "category_name")
    private String categoryName;
    
    @ToString.Exclude
    @OneToMany(mappedBy = "category", orphanRemoval = true)
    @OrderBy("id")
    private List<Article> articles = new ArrayList<>();
    
}
