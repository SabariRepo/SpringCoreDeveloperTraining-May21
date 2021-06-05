package com.ba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ba.dao.CustomerDAO;
import com.ba.model.Customer;

@Service //Spring Bean Class - Managed by the IoC Container
public class CustomerService {

	 @Autowired
	 CustomerDAO customerDAO;
	 
	 public boolean createTable() {
		 return customerDAO.createTable();
	 }
	 
	 
	 public boolean createCustomers(List<Customer> customers) {
		 return customerDAO.createCustomers(customers);
	 }
	 
	 public boolean updateCustomer(Customer customer) {
		 return customerDAO.updateCustomer(customer);
	 }
	 
	 public boolean deleteCustomer(int customerId) {
		 return customerDAO.deleteCustomer(customerId);
	 }
	 
	 public boolean findAllCustomers() {
		 return customerDAO.findAllCustomers();
	 }
	 
	 public boolean findCustomerByName(String customerName) {
		 return customerDAO.findCustomerByName(customerName);
	 }
}
