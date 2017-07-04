package com.walk.start.article.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walk.start.article.mapper.ArticleMapper;
import com.walk.start.domain.ArticleInfo;

@Service
public class ArticleService {

	@Autowired
	private ArticleMapper articleMapper;
	
	public ArticleInfo getArticleById(int articleId){
		return articleMapper.getArticleById(articleId); 
	}
}
