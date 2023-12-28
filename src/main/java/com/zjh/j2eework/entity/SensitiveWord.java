package com.zjh.j2eework.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description 敏感词
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/28
 */
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "sensitive_word")
public class SensitiveWord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sid", nullable = false)
    private Long id;
    
    @Column(name = "sensitive_word")
    private String sensitiveWord;
}
