package com.skillup.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

	@RequestMapping(value = "/welcome")
	public String home() {
		return "Welcome to Product page of SkillUp bank!";
	}
}
