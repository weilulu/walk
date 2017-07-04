package com.walk.start.about.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("about")
public class AboutController {

	@RequestMapping("")
	public ModelAndView about(){
		ModelAndView mv = new ModelAndView("about/me");
		return mv;
	}
}
