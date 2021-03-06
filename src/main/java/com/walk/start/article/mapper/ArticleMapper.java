package com.walk.start.article.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.walk.start.domain.ArticleInfo;

@Mapper
public interface ArticleMapper {

	@Select("select * from article_info where id=#{articleId}")
	ArticleInfo getArticleById(int articleId);
}
