package com.walk.start.category.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.walk.start.category.service.CategoryService;
import com.walk.start.domain.ArticleCategory;

@Controller
@RequestMapping("categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("")
	public ModelAndView category(){
		List<ArticleCategory> list = categoryService.getAllCategorys();
		ModelAndView mv = new ModelAndView("category/category");
		mv.addObject("categories", list);
		mv.addObject("active", "2");
		return mv;
	}
	
	@RequestMapping("getArticleInfo")
	@ResponseBody
	public Set<JSONObject> getArticleInfo(@RequestParam("name")String categoryName){
		Set<JSONObject> set = categoryService.getCategoryList(categoryName);
		System.out.println(set.toString());
		return set;
	}
}
