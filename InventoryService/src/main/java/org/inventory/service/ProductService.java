package org.inventory.service;

public class ProductService {

	//InventoryService inventoryService = new InventoryService();
	
	//How the InventoryService instance is going to be injected - Dependency Injection?
	InventoryService inventoryService;
	
	
	
	//Mode 2 - Setter Based Injection
	public void setInventoryService(InventoryService inventoryService) {
		System.out.println("Setter Based Injection");
		this.inventoryService = inventoryService;
	}
	
	
	//Mode 1 - Constructor Based Injection Service
	public ProductService(InventoryService inventoryService) {
		System.out.println("Constructor based Injection");
		this.inventoryService = inventoryService;
	}
	
	String productName;
	public ProductService(String name) {
		//System.out.println(name);
		productName = name;
	}
	public ProductService() {
		// TODO Auto-generated constructor stub
	}
	public void orderProduct() {
		
		boolean productAvailFlag = inventoryService.productAvailability(1001);
		
		if(productAvailFlag == true) {
			System.out.println("Product Available : "+this.productName);
		}else {
			System.out.println("Currently The Product is Unavaialable");
		}
		
	}
}
