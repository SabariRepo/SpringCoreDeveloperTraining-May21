package com.skillup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.skillup.model.Account;
import com.skillup.model.Product;
import com.skillup.service.AccountService;
import com.skillup.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@RequestMapping(value = "/welcome")
	public String home() {
		return "Welcome to Product page of SkillUp bank!";
	}
	//http://localhost:8080/SkillUpBank/product/get/2002?dataFormat=json
	@GetMapping("/get/{prodId}/{prodName}")
	public Product getAccountDetails(@PathVariable(value = "prodId") int productId,@PathVariable String prodName) {
		
		return new Product(productId,prodName,44.45f);
	}
	
	@GetMapping("/lists")
	public String listProducts(Model model) {
		
		List<Product> productsList  = productService.getAllProducts();
		model.addAttribute("products", productsList);
		return "productview";
	}
	
	@Autowired
	AccountService accountService;
	
	@GetMapping("/batchinsert")
	public void insertBatch() {
		accountService.accountBatchUpdate();
	}
	
	@GetMapping("/callproc")
	public void callAccountProcedure() {
		accountService.callgetAccountProc();
	}
}
