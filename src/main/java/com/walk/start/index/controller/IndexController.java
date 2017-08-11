package com.walk.start.index.controller;

import javax.servlet.http.HttpServletRequest;

import org.elasticsearch.common.lang3.StringUtils;
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
	
	@RequestMapping(value="")
	public ModelAndView index(Model model,HttpServletRequest request){
		String s = request.getParameter("page");
		int start = 0;
		if(StringUtils.isNotBlank(s)){
			start = Integer.valueOf(s);
		}
		Page<ArticleInfo> page = walkIndexService.getArticleInfoList(start);
		ModelAndView mv = new ModelAndView("index/index");
		if(page != null){
			//int nextPage = page.getNextPage();
			mv.addObject("currentPage", start == 0 ? 1:start+1);
		}
		boolean nextFlag = page.hasNextPage();
		model.addAttribute("page",page);
		mv.addObject("active", "0");
		mv.addObject("nextFlag", nextFlag);
		return mv;
	}

}
