package net.apry.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import net.apry.onlineshopping.ProductValidator;
import net.apry.onlineshopping.util.FileUploadUtility;
import net.apry.shoppingbackend.dao.CategoryDao;
import net.apry.shoppingbackend.dao.ProductDAO;
import net.apry.shoppingbackend.dto.Category;
import net.apry.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ProductDAO productDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	@RequestMapping(value="/products", method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation",required=false)String operation) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts",true);
		mv.addObject("categories", categoryDao.list());
		
		Product nProduct = new Product();
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		
		mv.addObject("product",nProduct);
		
		mv.addObject("title", "Manage Products");
		if(operation != null) {
			if(operation.equals("product")) {
				mv.addObject("message","Product Added Successfully");
			}
			else if(operation.equals("category")) {
				mv.addObject("message","Category Added Successfully");
			}
		}
		
		
		return mv;
	}
	
	
	@RequestMapping(value="/{id}/product",method=RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable int id) {

		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts",true);
		mv.addObject("title","Manage Product");
		//fetch the product from database
		Product nProduct = productDAO.get(id); 
		
		mv.addObject("product",nProduct);
		
		
		
		
		return mv;
	}
	
	
	
	//store
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult result, Model model,
			HttpServletRequest request) {
		
		if(mProduct.getId()==0) {
			new ProductValidator().validate(mProduct, result);
		}
		else {
			if(!mProduct.getFile().getOriginalFilename().equals("")) {
				new ProductValidator().validate(mProduct, result); 
			}
		}
		
		if(result.hasErrors()) {
			
			model.addAttribute("userClickManageProducts",true);
			model.addAttribute("title","Manage Products");
			return "page";
		}
		mProduct.setActive(true);
		logger.info(mProduct.toString());
		
		if(mProduct.getId()==0) {
			productDAO.add(mProduct);
		}else {

			productDAO.update(mProduct);
		}
		
		
		
		if(!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request,mProduct.getFile(),mProduct.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
	}
	
	
	@RequestMapping(value = "/product/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id) {
		
		Product product = productDAO.get(id);
		boolean isActive = product.isActive();
		
		product.setActive(!product.isActive());
		
		productDAO.update(product);
		
		return (isActive)? "You have succesfully deactivated the product with id" + product.getId() 
		: "You have succesfully activated the product with id" + product.getId() ;
		
	}
	
	//handling submission category
	
	@RequestMapping(value="/category", method=RequestMethod.POST)
	public String handleCategorySubmission(@ModelAttribute Category category) {
		categoryDao.add(category);
		return "redirect:/manage/products?operation=category";
	}
	
	
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		return categoryDao.list();
	}
	
	
	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}
	
	

}
