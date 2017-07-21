package com.walk.start.category.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.walk.start.domain.ArticleCategory;

@Mapper
public interface CategoryMapper {

	@Select("SELECT cate.name,DATE_FORMAT(info.create_time,'%Y-%m-%d') as createTime,info.title,cate.article_id as articleId" + 
			" FROM article_category AS cate LEFT JOIN article_info AS info " + 
			" ON cate.article_id = info.id" + 
			" GROUP BY cate.name,cate.article_id")
	public List<ArticleCategory> getAllCategorys();
	
	@Select("SELECT NAME FROM article_category GROUP BY NAME")
	public List<String> getCategoryNames();
}
