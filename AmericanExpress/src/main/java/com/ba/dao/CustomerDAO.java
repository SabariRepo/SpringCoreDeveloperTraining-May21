package com.ba.dao;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ba.model.Customer;

@Repository // Spring managed bean class
public class CustomerDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public boolean createTable() {

		boolean result_flag = false;
		try {
			jdbcTemplate
					.execute("create table customer(" + "cust_id int , cust_name varchar(30), cust_addr varchar(40))");
			result_flag = true;
		} catch (DataAccessException exception) {
			exception.printStackTrace();
		}

		return result_flag;
	}

	public boolean createCustomers(List<Customer> customers) {

		int rowsCount = 0; // default value to be initialized for the local variable

		// For Each Loop - For iterating you collection type
		for (Customer customer : customers) {

			try {
				rowsCount = rowsCount + jdbcTemplate.update("insert into customer values(?,?,?)", new Object[] {
						customer.getCustomerId(), customer.getCustmomerName(), customer.getCustomerAddress() });
			} catch (DataAccessException exception) {
				exception.printStackTrace();
			}
		}

		System.out.println("Total Rows Inserted" + rowsCount);

		if (rowsCount > 0)
			return true;
		else
			return false;
	}

	public boolean updateCustomer(Customer customer) {

		return false;
	}

	public boolean deleteCustomer(int customerId) {

		return false;
	}

	public boolean findAllCustomers() {

		return false;
	}

	public boolean findCustomerByName(String customerName) {

		return false;
	}
}
