package com.walk.start.category.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
	public JSONObject getAllCategorys(){
		List<String> cateList = categoryMapper.getCategoryNames();
		
		List<ArticleCategory> list = categoryMapper.getAllCategorys();
		if(list == null){
			return null;
		}
		//Map<String,List<ArticleCategory>> map = new HashMap<>();
		JSONObject json = new JSONObject();
		for(String name :cateList){
			List<ArticleCategory> newacList = new ArrayList<>();
			for(ArticleCategory ac : list){
				if(name.equals(ac.getName())){
					newacList.add(ac);
					json.put(name,newacList);
					//map.put(name, newacList);
				}
			}
		}
		return json;
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
