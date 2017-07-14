package com.walk.start.category.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.walk.start.category.mapper.CategoryMapper;
import com.walk.start.domain.ArticleCategory;

import redis.clients.jedis.ShardedJedis;

@Service
public class CategoryService {

	
    @Autowired
    private CategoryMapper categoryMapper;
    
	@Autowired
	private ShardedJedis jedis;
	
	@Autowired
	public List<ArticleCategory> getAllCategorys(){
		List<ArticleCategory> list = categoryMapper.getAllCategorys();
		if(list == null){
			return Collections.emptyList();
		}
		return list;
	}
	public Set<JSONObject> getCategoryList(String key){
		Set<String> set = jedis.zrange(key, 0, -1);
		if(set == null){
			return Collections.emptySet();
		}
		JSONArray jarray = JSONObject.parseArray(set.toString());
		Set<JSONObject> s = new HashSet<>();
		for(int index=0;index<jarray.size();index++){
			String arrayStr = jarray.getString(index);
			s.add(JSONObject.parseObject(arrayStr));
		}
		return s;
	}
}
