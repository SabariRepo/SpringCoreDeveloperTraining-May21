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
	 
	 public boolean updateCustomer(int cust_id,String cust_addr) {
		 return customerDAO.updateCustomer(cust_id,cust_addr);
	 }
	 
	 public boolean deleteCustomer(int customerId) {
		 return customerDAO.deleteCustomer(customerId);
	 }
	 
	 public List<Customer> findAllCustomers() {
		 return customerDAO.findAllCustomers();
	 }
	 
	 public Customer findCustomerByName(String customerName) {
		 return customerDAO.findCustomerByName(customerName);
	 }
}
