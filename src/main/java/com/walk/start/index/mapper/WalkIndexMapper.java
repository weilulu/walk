package com.walk.start.index.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.walk.start.domain.ArticleInfo;

@Mapper
public interface WalkIndexMapper {

	@Select("select * from article_info")
	List<ArticleInfo> getArticleInfoList();
	
	/*@Select("select * from article_content where article_id=#{articleId}")
	ArticleContent getAticleContent(int articleId);
*/}
