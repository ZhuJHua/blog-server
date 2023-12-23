package com.zjh.j2eework.service;

import com.zjh.j2eework.entity.Article;
import com.zjh.j2eework.pojo.Result;

/**
 * @Description Article接口
 * @Author 住京华 www.zhujinghua.com
 * @Date 2023/12/23
 */
public interface ArticleService {
    Result addArticle(Article article);
    
    Result delArticle(Long id);
    
    Result findAllArticle();
    
    Result updateArticle(Article article);
}
