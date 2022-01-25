package net.apry.onlineshopping.controller;

import javax.faces.flow.builder.ReturnBuilder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("greeting", "Welcome to Spring Web MVC");

		return mv;
	}

	@RequestMapping(value = "/requestParam")
	public ModelAndView requestParam(@RequestParam(value ="greeting", required = false) String greeting) {
		
		if(greeting ==null) {
			greeting = "Holla bitch";
		}
		
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("greeting", greeting);

		return mv;
	}
	
	@RequestMapping(value="/pathVariable/{greeting}")
	public ModelAndView pathVariable(@PathVariable("greeting")String greeting) {
		if(greeting==null) {
			greeting = "Holla Bitch";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}
	
	
	
	
}
