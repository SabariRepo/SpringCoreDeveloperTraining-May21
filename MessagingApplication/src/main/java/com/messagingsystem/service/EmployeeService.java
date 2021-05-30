package com.messagingsystem.service;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy( value = false)
public class EmployeeService {

	@PostConstruct
	public void init() {
		System.out.println("EmployeeService instance is created");
		//this.defaultNoOfMessage=10;
	}
}
