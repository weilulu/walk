package com.walk.start.index.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.walk.start.common.page.util.Page;
import com.walk.start.domain.ArticleInfo;
import com.walk.start.index.service.WalkIndexService;


@RestController
@RequestMapping(value="index")
public class IndexController {
	
	@Autowired
	private WalkIndexService walkIndexService;
	
	@RequestMapping(value="list")
	public ModelAndView index(Model model){
		Page<ArticleInfo> page = walkIndexService.getArticleInfoList();
		ModelAndView mv = new ModelAndView("index/index");
		model.addAttribute("page",page);
		mv.addObject("active", "0");
		return mv;
	}

}
