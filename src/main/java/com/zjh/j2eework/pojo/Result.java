package com.zjh.j2eework.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description 统一返回
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/23
 */
@Data
@AllArgsConstructor
public class Result {
    private int code;
    private String msg;
    private Object data;
}
