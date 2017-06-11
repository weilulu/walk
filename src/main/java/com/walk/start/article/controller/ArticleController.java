package com.walk.start.article.controller;

import com.walk.start.article.service.ArticleService;
import com.walk.start.domain.ArticleInfo;

@RestController
@RequestMapping("article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value="readArticle/{id}")
	public ModelAndView readArticle(@PathVariable("id")int id,Model model){
		if(id == 0){
			return new ModelAndView("error/error");
		}
		ArticleInfo article = articleService.getArticleById(id);
		model.addAttribute("article",article);
		return new ModelAndView("article/content");
	}
}

