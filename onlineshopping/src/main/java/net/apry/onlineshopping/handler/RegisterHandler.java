package net.apry.onlineshopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import net.apry.onlineshopping.model.RegisterModel;
import net.apry.shoppingbackend.dao.UserDAO;
import net.apry.shoppingbackend.dto.Address;
import net.apry.shoppingbackend.dto.Cart;
import net.apry.shoppingbackend.dto.User;

@Component
public class RegisterHandler {
	
	@Autowired
	private UserDAO userDAO;
	
	public RegisterModel init() {
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel , User user) {
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel , Address billing) {
		registerModel.setBilling(billing);
	}
	
	public String validateUser(User user, MessageContext error) {
		String transitoinValue ="success";
		
		if(!user.getPassword().equals(user.getConfirmPassword())) {
			error.addMessage(new MessageBuilder().error().source("confirmPassword").defaultText("Password does not match the confirm password").build());
			transitoinValue ="failure";
		}
		
		if(userDAO.getByEmail(user.getEmail())!=null) {
			error.addMessage(new MessageBuilder().error().source("email").defaultText("Email address already used").build());
			
			transitoinValue = "failure";
		}
		
		return transitoinValue;
	}
	
	public String saveAll(RegisterModel model) {
		String transitionValue ="success";
		
		//fetch the user
		
		User user = model.getUser();
		  
		if(user.getRole().equals("USER")) {
			Cart cart = new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		
		// save the user
		userDAO.addUser(user);
		
		// get the address
		
		Address billing = model.getBilling();
		billing.setUserId(user.getId());
		billing.setBilling(true);
		userDAO.addAddress(billing);
		
		return transitionValue;
	}

}
