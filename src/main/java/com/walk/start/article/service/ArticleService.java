package com.walk.start.article.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walk.article.entity.ArticleContent;
import com.walk.start.article.mapper.ArticleMapper;

@Service
public class ArticleService {

	@Autowired
	private ArticleMapper articleMapper;
	
	public ArticleContent getArticleById(int articleId){
		return articleMapper.getArticleById(articleId); 
	}
}
