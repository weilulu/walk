package com.walk.start.category.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.walk.start.domain.ArticleCategory;

@Mapper
public interface CategoryMapper {

	@Select("select name,count(article_id) as counts from article_category GROUP BY name")
	public List<ArticleCategory> getAllCategorys();
}
