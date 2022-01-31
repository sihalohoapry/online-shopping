package net.apry.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.apry.shoppingbackend.dao.ProductDAO;
import net.apry.shoppingbackend.dto.Product;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDao;
	
	private Product product;
	 
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.apry.shoppingbackend");
		context.refresh();
		productDao = (ProductDAO) context.getBean("productDAO");
		
	}
	
	@Test
	public void testCRUDProduct() {
		
		//create opration
		product = new Product();
		product.setName("Oppo Selfie S53");
		product.setBrand("Oppo");
		product.setDescription("This is description of Oppo Selfie S53");
		product.setUntiPrice(25000);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(3);
		
		assertEquals("Something went wrong while inserting a new product", true,productDao.add(product));
		
		//reading and updating the product
		
		product = productDao.get(2);
		product.setName("Samsung Galaxy S7");
		assertEquals("Something went wrong while updating the existing record",true,productDao.update(product));
		
		assertEquals("Something went wrong while updating the existing record",true,productDao.delete(product));
		
		
		assertEquals("Something went wrong while fetching the list of product", 6 , productDao.list().size());
	}
	

}
