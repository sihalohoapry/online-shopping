package net.apry.onlineshopping.exception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public ProductNotFoundException() {
		this("Product is Not available");
	}
	
	public ProductNotFoundException(String message) {
		this.message = System.currentTimeMillis() + ";" + message;
	}

	public String getMessage() {
		return message;
	}
	
	
}
