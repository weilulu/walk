package com.walk.start.index.controller;

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
		return mv;
	}

}
