package com.walk.start.search.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
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
		List<ArticleInfo> page = searchService.searchArticle(q);
		ModelAndView mv = new ModelAndView("search/list");
		mv.addObject("page", page);
		return mv;
	}
}
