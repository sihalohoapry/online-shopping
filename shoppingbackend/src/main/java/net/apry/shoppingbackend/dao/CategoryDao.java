package net.apry.shoppingbackend.dao;

import java.util.List;

import net.apry.shoppingbackend.dto.Category;

public interface CategoryDao {
	
	List<Category> list();
	Category get(int id);

}
