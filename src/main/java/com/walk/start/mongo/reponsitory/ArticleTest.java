package com.walk.start.mongo.reponsitory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import com.walk.start.mongo.entity.ArticleInfo;

@Component
public class ArticleTest {

	@Autowired    
	private MongoTemplate mongoTemplate;
	
	public List<ArticleInfo> queryAll(){
		//Query query = new Query(new Criteria("ArticleInfo").all(""));
		List<ArticleInfo> list = mongoTemplate.findAll(ArticleInfo.class,"posts");
		return list;
	}
}
