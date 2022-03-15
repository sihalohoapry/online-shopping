package net.apry.onlineshopping.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.apry.onlineshopping.model.UserModel;
import net.apry.shoppingbackend.dao.CartLineDAO;
import net.apry.shoppingbackend.dto.Cart;
import net.apry.shoppingbackend.dto.CartLine;

@Service("cartService")
public class CartService {
	
	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private HttpSession session;
	
	//return the cart of the user who has loggin
	private Cart getCart() {
		return ((UserModel)session.getAttribute("userModel")).getCart();
	}
	
	//return the entire  cart lines
	public List<CartLine> getCartLines(){
		Cart cart = this.getCart();
		return cartLineDAO.list(cart.getId());
	}

}
