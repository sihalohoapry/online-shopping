package net.apry.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.apry.onlineshopping.exception.ProductNotFoundException;
import net.apry.shoppingbackend.dao.CategoryDao;
import net.apry.shoppingbackend.dao.ProductDAO;
import net.apry.shoppingbackend.dto.Category;
import net.apry.shoppingbackend.dto.Product;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "Home");
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUGE");

		// passing list category
		mv.addObject("categories", categoryDao.list());

		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "About");
		mv.addObject("categories", categoryDao.list());
		mv.addObject("userClickAbout", true);
		return mv;

	}

	@RequestMapping(value = "/show/all/products")
	public ModelAndView allproducts() {
		ModelAndView mv = new ModelAndView("page");

		mv.addObject("title", "All Products");
		mv.addObject("categories", categoryDao.list());
		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");

		// categoryDeo to fetch a single category
		Category category = null;
		category = categoryDao.get(id);

		mv.addObject("title", category.getName());

		// pasing list category
		mv.addObject("categories", categoryDao.list());

		// pasing the single category object
		mv.addObject("category", category);

		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}

	// single product

	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException  {
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		
		if(product==null) throw new ProductNotFoundException();
		
		//update the views count
		product.setView(product.getView()+1);
		productDAO.update(product);
		
		//
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);				
		return mv;
	}
	
	@RequestMapping(value = "/register")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Register");
		return mv;

	}
	
	/*Login*/
	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam(name = "error", required = false) String error) {
		ModelAndView mv = new ModelAndView("login");
		if(error!=null) {
			mv.addObject("message", "Invalid User and Password");
		}
		mv.addObject("title", "Login");
		return mv;

	}
	
	/* access denied page*/
	@RequestMapping(value = "/access-denied")
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("title", "403 - Access Denied");
		mv.addObject("errorTitle", "Aha! Caugth You.");
		mv.addObject("errorDescription", "You are not authorized to view this page!");
		return mv;

	}
	

}
