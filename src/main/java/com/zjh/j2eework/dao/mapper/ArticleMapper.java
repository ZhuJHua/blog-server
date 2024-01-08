package com.zjh.j2eework.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjh.j2eework.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Description
 * @Author 住京华 www.zhujinghua.com
 * @Date 2024/1/8
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    
    //文章浏览量+1
    @Update("update article set view=view+1 where aid=#{id}")
    void updateViews(Long id);
    
    @Select("SELECT aid AS id,title,content,post_time,tag,view,user_uid,category_cid FROM article")
    @Results({@Result(property = "user", column = "user_uid", one = @One(select = "com.zjh.j2eework.dao" +
            ".mapper.UserMapper.selectById")), @Result(property = "category", column = "category_cid", one =
    @One(select = "com.zjh.j2eework.dao.mapper.CategoryMapper.selectById"))})
    List<Article> selectListWithUserAndCategory();
    
    @Insert("insert into article (title, content, post_time, tag, view, user_uid, category_cid) " +
            "values (#{article.title}, #{article.content}, #{article.postTime}, #{article.tag}, " +
            "#{article.view}, #{article.user.id}, #{article.category.id})")
    void saveArticle(@Param("article") Article article);
    
}
