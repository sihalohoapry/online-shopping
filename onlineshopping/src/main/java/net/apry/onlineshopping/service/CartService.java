package net.apry.onlineshopping.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.apry.onlineshopping.model.UserModel;
import net.apry.shoppingbackend.dao.CartLineDAO;
import net.apry.shoppingbackend.dao.ProductDAO;
import net.apry.shoppingbackend.dto.Cart;
import net.apry.shoppingbackend.dto.CartLine;
import net.apry.shoppingbackend.dto.Product;

@Service("cartService")
public class CartService {
	
	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private ProductDAO productDAO;
	
	//return the cart of the user who has loggin
	private Cart getCart() {
		return ((UserModel)session.getAttribute("userModel")).getCart();
	}
	
	//return the entire  cart lines
	public List<CartLine> getCartLines(){
		Cart cart = this.getCart();
		return cartLineDAO.list(cart.getId());
	}

	public String manageCartLine(int cartLineId, int count) {
		//fetch the cart line
		CartLine cartLine = cartLineDAO.get(cartLineId);
		//checked cartline 
		if(cartLine == null) {
			return "result= unavailable";
		}else {
			
			Product product = cartLine.getProduct();
			double oldTotal = cartLine.getTotal();		
			
			
			if(product.getQuantity() <= count) {
				count = product.getQuantity();
			}			
			cartLine.setProductCount(count);
			cartLine.setBuyingPrice(product.getUntiPrice());
			cartLine.setTotal(product.getUntiPrice() * count);
			cartLineDAO.update(cartLine);
			
			Cart cart = this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());			
			cartLineDAO.updateCart(cart);
			
			return "result=updated";
		}
		
		 
	}

	public String deleteCartLine(int cartLineId) {
		//fetch the cart line
		
		CartLine cartLine = cartLineDAO.get(cartLineId);
		
		if(cartLine == null) {
			return "result=error";
		}else {
			
			//update cart
			Cart cart = this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - cartLine.getTotal());
			cart.setCartLines(cart.getCartLines() - 1 );
			cartLineDAO.updateCart(cart);
			
			//remove cartline
			cartLineDAO.delete(cartLine);
			return "result=deleted";
			
		}
	}

	public String addCartLine(int product_id) {
		
		String response = null;
		Cart cart = this.getCart();
		CartLine cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), product_id);
		
		if (cartLine == null) {
			//add a new cart line
			cartLine = new CartLine();
			
			//fecth the product
			Product product = productDAO.get(product_id);
			cartLine.setCartId(cart.getId());
			cartLine.setProduct(product);
			cartLine.setBuyingPrice(product.getUntiPrice());
			cartLine.setProductCount(1);
			cartLine.setTotal(product.getUntiPrice());
			cartLine.setAvailable(true);
			
			cartLineDAO.add(cartLine);
			
			cart.setCartLines(cart.getCartLines()+1);
			cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
			cartLineDAO.updateCart(cart);
			
			response = "result=added";
			
			
		}
		else {
			//check cartline has maximum count
			if(cartLine.getProductCount() < 3) {
				//update product count for 
				response = this.manageCartLine(cartLine.getId(), cartLine.getProductCount()+ 1);
				
			}else {
				response = "result-max";
			}
		}
				
		return response;
		
		
	}

}
