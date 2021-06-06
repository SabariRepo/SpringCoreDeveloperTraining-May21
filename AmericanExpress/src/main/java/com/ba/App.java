package com.ba;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ba.configuration.AmericanExpressAppConfig;
import com.ba.dao.CustomerAccountDAO;
import com.ba.model.Customer;
import com.ba.service.CustomerAccountService;
import com.ba.service.CustomerService;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
				AmericanExpressAppConfig.class);

		CustomerService customerService = applicationContext.getBean(CustomerService.class);
		
		CustomerAccountDAO customerAccountDAO = applicationContext.getBean(CustomerAccountDAO.class);
		
		CustomerAccountService customerAccountService = applicationContext.getBean(CustomerAccountService.class);

		
		//customerAccountDAO.depositAmount(101, 6000);
		
		customerAccountService.depositAmount1(103, 50000);
		
		// DDL -> Data Defintion Language -> Creation of a table
//      boolean result =  customerService.createTable();

		/*
		 * if(result) { System.out.println("Table Created!."); }else {
		 * System.out.println("Table Not Created!"); }
		 */

		/*
		 * Scanner scanner = new Scanner(System.in);
		 * 
		 * System.out.println("Enter the Customer ID You want To De-Activate:"); int
		 * cust_id = scanner.nextInt();
		 */

		//customerService.findAllCustomers().forEach(System.out::println);
		//IncorrectResultSizeDataAccessException: Incorrect result size: expected 1, actual 2
		//Customer customer = customerService.findCustomerByName("SundarPichai");
		//System.out.println(customer);
		/*
		 * System.out.println("Enter the Change of Address:"); String cust_addr =
		 * scanner.next();
		 */

		// System.out.println("Enter the Customer ID");

		// boolean result = customerService.updateCustomer(cust_id, cust_addr);

		/*
		 * boolean result = customerService.deleteCustomer(cust_id);
		 * 
		 * System.out.println(result);
		 */

		/*
		 * List<Customer> customers = new ArrayList<>(); String cont = null;
		 * 
		 * do { System.out.println("Enter Customer ID:"); int custId =
		 * scanner.nextInt();
		 * 
		 * System.out.println("Enter Customer Name:"); String custName = scanner.next();
		 * 
		 * System.out.println("Enter Customer Address:"); String custAddr =
		 * scanner.next();
		 * 
		 * Customer customer = new Customer(custId, custName, custAddr);
		 * customers.add(customer);
		 * 
		 * System.out.println("Do you want to add more Customer Data:Yes/No"); cont =
		 * scanner.next();
		 * 
		 * } while (cont.equals("Yes") || cont.equals("yes"));
		 * 
		 * 
		 * boolean result = customerService.createCustomers(customers);
		 * 
		 * System.out.println(result);
		 */

		// customers.forEach(System.out::println); //Lambda Expression
	}
}
