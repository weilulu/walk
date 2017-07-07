package com.walk.start.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
		model.addAttribute("active", "1");
		return new ModelAndView("article/content");
	}
}

