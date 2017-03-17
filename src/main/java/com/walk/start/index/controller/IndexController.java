package com.walk.start.index.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class IndexController {

	@RequestMapping(value="index")
	public ModelAndView index(Model model){
		ModelAndView mv = new ModelAndView("index/index");
		model.addAttribute("test","");
		return mv;
	}
}
