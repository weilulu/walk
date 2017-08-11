package com.walk.start.index.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.walk.start.domain.ArticleInfo;

@Mapper
public interface WalkIndexMapper {

	@Select("select id,title,author,summary,DATE_FORMAT(post_time,'%Y-%m-%d %T') as postTime from article_info limit #{start},8")
	List<ArticleInfo> getArticleInfoList(@Param("start")int start);
	
	@Select ("select count(id) from article_info")
	long getAllarticleCount();
	/*@Select("select * from article_content where article_id=#{articleId}")
	ArticleContent getAticleContent(int articleId);
*/}
