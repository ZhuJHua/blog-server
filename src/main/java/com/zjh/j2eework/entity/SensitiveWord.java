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
 * @Description 敏感词
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/28
 */
@TableName("sensitive_word")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class SensitiveWord {
    @TableId(type = IdType.AUTO,value = "sid")
    private Long id;
    
    @TableField(value = "sensitive_word")
    private String sensitiveWord;
}
