package com.walk.start.test.controller;

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
