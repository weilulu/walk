package com.walk.start.category.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("category")
public class CategoryController {

	@RequestMapping("")
	public ModelAndView about(){
		ModelAndView mv = new ModelAndView("category/category");
		return mv;
	}
}
