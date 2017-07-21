package com.walk.start.archives.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("archives")
public class ArchivesController {

	@RequestMapping("")
	public ModelAndView getArchives(){
		ModelAndView mv = new ModelAndView("archives/list");
		return mv;
	} 
}
