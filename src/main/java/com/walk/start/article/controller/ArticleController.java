package com.walk.start.article.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.walk.article.entity.ArticleContent;
import com.walk.start.article.service.ArticleService;

@RestController
@RequestMapping("article")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@GetMapping(value="readArticle/{id}")
	public ModelAndView readArticle(@PathVariable("id")int id,Model model){
		if(id == 0){
			return new ModelAndView("error/error");
		}
		ArticleContent article = articleService.getArticleById(id);
		model.addAttribute("article",article);
		return new ModelAndView("/article/article_content");
	}
}

