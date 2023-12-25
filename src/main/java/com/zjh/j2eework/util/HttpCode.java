package com.zjh.j2eework.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Description 状态码枚举
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/25
 */
@AllArgsConstructor
@Getter
public enum HttpCode {
    OK(200, "成功"),
    BAD_REQUEST(400, "请求错误"),
    SERVER_ERROR(500, "服务器内部错误");
    
    private final int code;
    private final String description;
}
