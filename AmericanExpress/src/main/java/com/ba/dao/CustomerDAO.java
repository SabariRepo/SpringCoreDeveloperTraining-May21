package com.ba.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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

	public boolean updateCustomer(int cust_id, String cust_addr) {

		try {
			jdbcTemplate.update("update customer set cust_addr=? where cust_id=?", new Object[] { cust_addr, cust_id });
		} catch (DataAccessException exception) {
			exception.printStackTrace();
		}

		return true;
	}

	public boolean deleteCustomer(int customerId) {

		try {
			jdbcTemplate.update("delete from customer where cust_id=?", new Object[] { customerId });
		} catch (DataAccessException exception) {
			exception.printStackTrace();
		}

		return true;
	}

	public List<Customer> findAllCustomers() {

		// jdbcTemplate.query

		// Anonymous Class Style
		/*
		 * RowMapper<Customer> rm = new RowMapper<Customer>() {
		 * 
		 * @Override public Customer mapRow(ResultSet rs, int rowNum) throws
		 * SQLException { int cust_id = rs.getInt(1); String cust_name =
		 * rs.getString(2); String cust_addr = rs.getString(3);
		 * 
		 * System.out.println("This is Row Number: " + rowNum);
		 * 
		 * Customer customer = new Customer(cust_id, cust_name, cust_addr);
		 * 
		 * return customer; } };
		 */

		// Lambda Style
		/*
		 * RowMapper<Customer> rm1 = (rs, rowNum) -> { int cust_id = rs.getInt(1);
		 * String cust_name = rs.getString(2); String cust_addr = rs.getString(3);
		 * 
		 * System.out.println("This is Row Number: " + rowNum);
		 * 
		 * Customer customer = new Customer(cust_id, cust_name, cust_addr);
		 * 
		 * return customer; };
		 */

		List<Customer> customer = jdbcTemplate.query("select * from customer where cust_name=?",
				new CustomerRowMapper(), new Object[] { "SundarPichai" });

		// List<Customer> customer = jdbcTemplate.query("select * from customer where
		// cust_name=?", new CustomerRowMapper(),new Object[] {"SundarPichai"});

		return customer;
	}

	public Customer findCustomerByName(String customerName) {

		// return jdbcTemplate.queryForObject("select * from customer where
		// cust_name=?",new Object[] {customerName},new CustomerRowMapper());
		// Columne unique or column Primary key
		return jdbcTemplate.queryForObject("select * from customer where cust_name=?", new Object[] { customerName },
				new int[] { java.sql.Types.VARCHAR }, new CustomerRowMapper());
	}
}
