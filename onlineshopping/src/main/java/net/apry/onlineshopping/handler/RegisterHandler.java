package net.apry.onlineshopping.handler;

import org.springframework.stereotype.Component;

import net.apry.onlineshopping.model.RegisterModel;
import net.apry.shoppingbackend.dto.Address;
import net.apry.shoppingbackend.dto.User;

@Component
public class RegisterHandler {
	
	public RegisterModel init() {
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel , User user) {
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel , Address billing) {
		registerModel.setBilling(billing);
	}

}
