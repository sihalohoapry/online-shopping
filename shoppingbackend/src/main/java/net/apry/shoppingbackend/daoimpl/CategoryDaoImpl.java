package net.apry.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.apry.shoppingbackend.dao.CategoryDao;
import net.apry.shoppingbackend.dto.Category;


@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao {

	private static List<Category> categories = new ArrayList<>();

	static {
		Category category = new Category();

		// adding first category

		category.setId(1);
		category.setName("Televisi");
		category.setDescription("This is deskription of televition");
		category.setImageURL("CAT_1.png");

		categories.add(category);


		// adding 2nd category
		category = new Category();

		category.setId(2);
		category.setName("Mobile");
		category.setDescription("This is deskription of Mobile");
		category.setImageURL("CAT_2.png");

		categories.add(category);


		// adding 3 category
		category = new Category();
		category.setId(3);
		category.setName("Laptop");
		category.setDescription("This is deskription of Laotio");
		category.setImageURL("CAT_3.png");

		categories.add(category);

	}

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Override
	public Category get(int id) {
		//enchange for loop
		
		for(Category category: categories) {
			if (category.getId()==id) return category;
		}
		
		return null;
	}

}
