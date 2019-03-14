package com.websit.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class T_indesController {
	@RequestMapping("/")
	public String toIndex(){
		System.out.println("999999999999");
		
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName("index.html");
		return "redirect:views/home/index.html";
	}

}
