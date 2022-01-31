package net.apry.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.apry.shoppingbackend.dao.CategoryDao;
import net.apry.shoppingbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static CategoryDao categoryDao;
	
	private Category category;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.apry.shoppingbackend");
		context.refresh();
		categoryDao = (CategoryDao) context.getBean("categoryDao");
	}
	
//	@Test
//	public void testAddCategory() {
//		
//		category = new Category();
//		category.setName("Laptop");
//		category.setDescription("This is deskription of laptop");
//		category.setImageURL("CAT_2.png");
//		
//		assertEquals("Successfully",true,categoryDao.add(category));
//	}
	
//	@Test
//	public void testGetCategory() {
//		category = categoryDao.get(2);
//		assertEquals("Successfully","Laptop",category.getName());
//		
//	}
	
//	@Test
//	public void testUpdateCategory() {
//		category = categoryDao.get(1);
//		category.setName("Laptop Gaming");
//		assertEquals("Successfully update",true,categoryDao.update(category));
//		
//	}
	
//	@Test
//	public void deleteCategory() {
//		category = categoryDao.get(2);
//		assertEquals("Successfully delete", true, categoryDao.delete(category));
//	}
	
//	@Test
//	public void testListCategory() {
//		assertEquals("Successfully fecth list", 1, categoryDao.list().size());
//	}

//	@Test
//	public void testCRUDCategory() {
//		
//		//add category
//		category = new Category();
//		category.setName("Laptop");
//		category.setDescription("This is deskription of laptop");
//		category.setImageURL("CAT_1.png");
//		
//		assertEquals("Successfully",true,categoryDao.add(category));
//		
//		category = new Category();
//		category.setName("Television");
//		category.setDescription("This is deskription of television");
//		category.setImageURL("CAT_2.png");
//		
//		assertEquals("Successfully",true,categoryDao.add(category));
//		
//		category = new Category();
//		category.setName("Mobile");
//		category.setDescription("This is deskription of mobile");
//		category.setImageURL("CAT_2.png");
//		
//		assertEquals("Successfully",true,categoryDao.add(category));
//		
//		//fetching and updating the category
//		category.setName("Laptop Gaming");
//		assertEquals("Successfully update",true,categoryDao.update(category));
//		
//		//delete
//		
//		category = categoryDao.get(2);
//		assertEquals("Successfully delete", true, categoryDao.delete(category));
//		
//		//check list
//		assertEquals("Successfully fecth list", 2, categoryDao.list().size());
//		
//		
//	}
	
	
}
