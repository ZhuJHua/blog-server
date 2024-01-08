package com.zjh.j2eework.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjh.j2eework.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Description
 * @Author 住京华 www.zhujinghua.com
 * @Date 2024/1/8
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
    @Select("select * from category where category_name=#{name}")
    Category findCategoryByName(String name);
}
