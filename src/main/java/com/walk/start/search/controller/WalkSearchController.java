package com.walk.start.search.controller;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.walk.start.domain.ArticleInfo;
import com.walk.start.search.service.WalkSearchService;

@Controller
@RequestMapping("search")
public class WalkSearchController {

	@Autowired
	private WalkSearchService searchService;
	
	@RequestMapping("result")
	public ModelAndView result(Model model,HttpServletRequest request){
		String q = request.getParameter("q");
		Page<ArticleInfo> page = searchService.searchArticle(q);
		ModelAndView mv = new ModelAndView("search/list");
		if(page == null){
			//com.walk.start.common.page.util.Page<ArticleInfo> p = new com.walk.start.common.page.util.Page<ArticleInfo>();
			//p.setItems(Collections.emptyList());
			mv.addObject("page", Collections.emptyList());
		}else{
			mv.addObject("page",page.getContent());
		}
		mv.addObject("total",page == null ? 0 : page.getTotalPages());
		mv.addObject("active", "");
		return mv;
	}
}
