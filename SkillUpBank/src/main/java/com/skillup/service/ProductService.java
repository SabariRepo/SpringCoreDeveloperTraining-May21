package com.skillup.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.skillup.model.Product;

@Service
public class ProductService {

	public List<Product> getAllProducts(){
		
		Product product1 = new Product(1001,"iPad",44.45f);
		Product product2 = new Product(1001,"iPad",44.45f);
		Product product3 = new Product(1001,"iPad",44.45f);
		
		List<Product> productsList = new ArrayList<>();
		
		productsList.add(product1);
		productsList.add(product2);
		productsList.add(product3);
		
		return productsList;
	}
}
