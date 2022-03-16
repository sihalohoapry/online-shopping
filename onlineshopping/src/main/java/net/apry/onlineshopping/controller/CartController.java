package net.apry.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import net.apry.onlineshopping.service.CartService;

@Controller
@RequestMapping("/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping("/show")
	public ModelAndView showCart(@RequestParam(name="result", required=false)String result) {
		ModelAndView mv = new ModelAndView("page");
		
		if(result!=null) {
			switch (result) {
			case "updated":
					mv.addObject("message","CartLine has been updated successfully!");
				break;
			case "added":
				mv.addObject("message","CartLine has been added successfully!");
			break;
			case "unavailable":
				mv.addObject("message","Product quantity is not availabe!");
			break;
			case "error":
				mv.addObject("message","Something went wrong!");
			break;
			case "maximum":
				mv.addObject("message","cart line has reached to maximum count  //"
						+ "");
			break;
			
			

//			default:
//				break;
			}
		}
		
		mv.addObject("title", "User Cart");
		mv.addObject("userClickShowCart", true);
		mv.addObject("cartLines", cartService.getCartLines());
		return mv ;
	}
	
	@RequestMapping("/{cartLineId}/update")
	public String updateCart(@PathVariable int cartLineId,@RequestParam int count ) {
		String response = cartService.manageCartLine(cartLineId, count);
		return "redirect:/cart/show?"+response ;
	}
	
	@RequestMapping("/{cartLineId}/delete")
	public String deleteCart(@PathVariable int cartLineId) {
		String response = cartService.deleteCartLine(cartLineId);
		return "redirect:/cart/show?"+response ;
	}
	
	@RequestMapping("/add/{product_id}/product")
	public String addCart(@PathVariable int product_id) {
		String response = cartService.addCartLine(product_id);
		return "redirect:/cart/show?"+response ;
	}
	

}
