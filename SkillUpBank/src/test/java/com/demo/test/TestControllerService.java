package com.demo.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.skillup.controller.ProductController;
import com.skillup.model.Product;
import com.skillup.service.ProductService;

public class TestControllerService {

	private MockMvc mockMvc;

	// Controller instance
	@InjectMocks
	private ProductController productController;

	// Service Instance
	@Mock
	private ProductService productService;

	// Initialization Setup has to be done
	@Before
	public void setup() {
		MockitoAnnotations.openMocks(this);

		this.mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
	}

	@Test
	public void testProductService() throws Exception {
		Product product1 = new Product(1002, "iPad", 44.45f);
		Product product2 = new Product(1002, "Mobile Phone", 44.45f);
		Product product3 = new Product(1003, "Wallet", 23.45f);

		List<Product> productsList = new ArrayList<>();

		productsList.add(product1);
		productsList.add(product2);
		//productsList.add(product3);
		
		//1. when and what to return - ProductService
		
		when(productService.getAllProducts()).thenReturn((List<Product>) productsList);
		//Mockito
		this.mockMvc.perform(get("/product/lists"))
				.andExpect(status().isOk()) //Success Response - 200
				.andExpect(view().name("productview"))
				.andExpect(model().attribute("products", org.hamcrest.Matchers.hasSize(2)));

	}
}
