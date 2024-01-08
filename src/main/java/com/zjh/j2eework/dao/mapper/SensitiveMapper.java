package com.zjh.j2eework.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjh.j2eework.entity.SensitiveWord;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * @Description
 * @Author 住京华 www.zhujinghua.com
 * @Date 2024/1/8
 */
@Mapper
public interface SensitiveMapper extends BaseMapper<SensitiveWord> {
    
    //返回一个set，set里面是所有的敏感词
    @Select("select distinct sensitive_word from sensitive_word")
    Set<String> getSensitiveWord();
    
    @Delete("delete from sensitive_word where sensitive_word=#{name}")
    void delSensitiveWord(String name);
}
