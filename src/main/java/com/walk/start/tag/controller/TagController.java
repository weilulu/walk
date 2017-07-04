package com.walk.start.tag.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("tag")
public class TagController {

	@RequestMapping("")
	public ModelAndView about(){
		ModelAndView mv = new ModelAndView("tag/tag");
		return mv;
	}
}
