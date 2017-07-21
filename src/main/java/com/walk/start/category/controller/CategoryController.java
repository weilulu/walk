package com.walk.start.category.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.walk.start.category.service.CategoryService;

@Controller
@RequestMapping("categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("")
	public ModelAndView category(){
		//Map<String,List<ArticleCategory>> map = categoryService.getAllCategorys();
		JSONObject json = categoryService.getAllCategorys();
		ModelAndView mv = new ModelAndView("category/category");
		mv.addObject("categories",json);
		mv.addObject("active", "2");
		return mv;
	}
	
	/*@RequestMapping("getArticleInfo")
	@ResponseBody
	public Set<JSONObject> getArticleInfo(@RequestParam("name")String categoryName){
		Set<JSONObject> set = categoryService.getCategoryList(categoryName);
		System.out.println(set.toString());
		return set;
	}*/
}
