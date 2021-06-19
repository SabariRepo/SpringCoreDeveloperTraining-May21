package com.skillup.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.skillup.model.Account;
import com.skillup.model.Product;

@RestController
@RequestMapping("/product")
public class ProductController {

	@RequestMapping(value = "/welcome")
	public String home() {
		return "Welcome to Product page of SkillUp bank!";
	}
	//http://localhost:8080/SkillUpBank/product/get/2002?dataFormat=json
	@GetMapping("/get/{prodId}/{prodName}")
	public Product getAccountDetails(@PathVariable(value = "prodId") int productId,@PathVariable String prodName) {
		
		return new Product(productId,prodName,44.45f);
	}
	
	
}
