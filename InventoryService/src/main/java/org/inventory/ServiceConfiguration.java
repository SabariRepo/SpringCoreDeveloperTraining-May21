package org.inventory;

import org.inventory.service.InventoryService;
import org.inventory.service.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Java Based Configuration File
@Configuration
public class ServiceConfiguration {

	@Bean(name = "inventory")
	public InventoryService createInventoryInstance() {
		return new InventoryService();
	}
	
	@Bean(name = "product1")
	public ProductService createProductService() {
		ProductService productService = new ProductService();
		productService.setInventoryService(createInventoryInstance());
		return productService;
	}
	
}
