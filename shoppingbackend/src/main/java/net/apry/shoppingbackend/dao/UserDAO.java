package net.apry.shoppingbackend.dao;

import java.util.List;

import net.apry.shoppingbackend.dto.Address;
import net.apry.shoppingbackend.dto.Cart;
import net.apry.shoppingbackend.dto.User;

public interface UserDAO {
	
	boolean addUser(User user);
	User getByEmail(String email);
	
	boolean addAddress(Address address);
	
	//alternative
	// Address getBillingAddress(int userId);
	// List<Address> listShippingAddress(int userId);
	
	Address getBillingAddress(int userId);
	List<Address> listShippingAddress(int userId);
	
	boolean updateCart(Cart cart);

}
