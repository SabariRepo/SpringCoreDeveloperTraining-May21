package com.ba.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ba.model.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {

		int cust_id = rs.getInt(1);
		String cust_name = rs.getString(2);
		String cust_addr = rs.getString(3);
		
		System.out.println("This is Row Number: " + rowNum);
		
		Customer customer = new Customer(cust_id, cust_name, cust_addr);
		
		return customer;
	}
}
