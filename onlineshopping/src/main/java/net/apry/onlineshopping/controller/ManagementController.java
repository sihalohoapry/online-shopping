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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		}
		
		
		return mv;
	}
	
	
	//store
	@RequestMapping(value="/products", method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult result, Model model,
			HttpServletRequest request) {
		
		new ProductValidator().validate(mProduct, result);
		
		if(result.hasErrors()) {
			
			model.addAttribute("userClickManageProducts",true);
			model.addAttribute("title","Manage Products");
			return "page";
		}
		mProduct.setActive(true);
		logger.info(mProduct.toString());
		productDAO.add(mProduct);
		
		if(!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request,mProduct.getFile(),mProduct.getCode());
		}
		
		return "redirect:/manage/products?operation=product";
	}
	
	
	@ModelAttribute("categories")
	public List<Category> getCategories(){
		return categoryDao.list();
	}

}
