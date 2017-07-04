package com.walk.start.test.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value="/test")
public class Test {

	//@Autowired
	//private VelocityEngine velocityEngine;
	
	@RequestMapping(value="test")
	public ModelAndView test(Model model){
		ModelAndView mv = new ModelAndView("test");
		model.addAttribute("test","hello");
		return mv;
		
	}
}
