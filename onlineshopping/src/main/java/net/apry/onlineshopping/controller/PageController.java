package net.apry.onlineshopping.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.apry.shoppingbackend.dao.CategoryDao;
import net.apry.shoppingbackend.dto.Category;

@Controller
public class PageController {
	
	@Autowired
	private CategoryDao categoryDao;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title", "Home");
		
		//passing list category
		mv.addObject("categories",categoryDao.list());
		
		mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping(value = "/about" )
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "About");
		mv.addObject("userClickAbout", true);
		return mv;
		
	}
	
	@RequestMapping(value = "/show/all/products" )
	public ModelAndView allproducts() {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "All Products");
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	@RequestMapping(value = "/show/category/{id}/products" )
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		
		//categoryDeo to fetch a single category
		Category category = null;
		category = categoryDao.get(id);

		mv.addObject("title", "All Products");
		mv.addObject("userClickAllProducts", true);
		return mv;
	}
	
	@RequestMapping(value = "/popularitems" )
	public ModelAndView popularitems() {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "Popular Items");
		mv.addObject("userClickPopularItems", true);
		return mv;
	}
	@RequestMapping(value = "/newarrivals" )
	public ModelAndView newarrivals() {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "newarrivals");
		mv.addObject("userClickNewArrivals", true);
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
