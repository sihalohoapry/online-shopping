package net.apry.shoppingbackend.test;

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
		productDao = (ProductDAO) context.getBean("productDao");
		
	}
	
	@Test
	public void testCRUDProduct() {
		
	}
	

}
