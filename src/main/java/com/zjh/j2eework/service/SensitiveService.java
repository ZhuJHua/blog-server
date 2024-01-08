package com.zjh.j2eework.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zjh.j2eework.entity.SensitiveWord;

import java.util.Set;

/**
 * @Description 敏感词接口
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/28
 */
public interface SensitiveService extends IService<SensitiveWord> {
    void initSensitiveMap();
    
    boolean containsSensitiveWord(String text);
    
    void addSensitive(SensitiveWord sensitive);
    
    void delSensitive(String name);
    
    Set<String> getWordList();
}
