package com.walk.start.mongo.reponsitory;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import com.walk.start.mongo.entity.ArticleInfo;

@Component
public interface ArticleInfoReponsitory extends MongoRepository<ArticleInfo,String>{

	@Query("{'post_time':?0}")
	//@Query("select u from ArticleInfo u")
	List<ArticleInfo> queryAll(String postTime);
}
