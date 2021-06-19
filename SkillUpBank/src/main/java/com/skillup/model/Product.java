package com.skillup.model;

public class Product {

	private int productId;
	private String productName;
	private float productPrice;

	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Product(int productId, String productName, float productPrice) {
		//super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}




	public int getProductId() {
		return productId;
	} //Angular + Spring Boot (Microservice - Spring Cloud) + SQL or NoSQl (MongoDB)

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ "]";
	}
	
	

}
