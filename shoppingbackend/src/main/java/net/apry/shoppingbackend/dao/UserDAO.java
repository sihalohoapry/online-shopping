package net.apry.shoppingbackend.dao;

import net.apry.shoppingbackend.dto.Address;
import net.apry.shoppingbackend.dto.Cart;
import net.apry.shoppingbackend.dto.User;

public interface UserDAO {
	
	boolean addUser(User user);
	
	boolean addAddress(Address address);
	
	boolean addCart(Cart cart);

}
