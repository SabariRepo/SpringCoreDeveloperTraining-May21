package com.ba.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.mysql.cj.jdbc.MysqlSavepoint;

@Repository
public class CustomerAccountDAO {

	// First Approach is: Programmatic Transaction Management

	@Autowired
	JdbcTemplate jdbcTemplate;

	//@Autowired
	TransactionTemplate transactionTemplate;

	public void depositAmount1(int custId, int amount) {
		try {
			System.out.println("Inside Deposit Amount 1");
		jdbcTemplate.update("update customer_account set amount=? where cust_id=?",
				new Object[] { amount, custId });

		jdbcTemplate.update("update customer_account set amount=? where cust_id=?",
				new Object[] { amount + 1, custId });
		
		jdbcTemplate.update("update customer_account set amount=? where cust_id=?",
				new Object[] { amount + 2, custId });
		}catch(Exception e) {
			e.printStackTrace();
		}
		//int y = 20/0;
		
	}
	public void depositAmount(int custId, int amount) {

		
		transactionTemplate.execute(new TransactionCallback<Object>() {
			MysqlSavepoint savePoint=null;
			@Override
			//Representation of the status of a transaction.
			public Object doInTransaction(TransactionStatus status) {
				try {
					jdbcTemplate.update("update customer_account set amount=? where cust_id=?",
							new Object[] { amount, custId });

					jdbcTemplate.update("update customer_account set amount=? where cust_id=?",
							new Object[] { amount + 1, custId });
					
					savePoint = (MysqlSavepoint)status.createSavepoint();
					
					jdbcTemplate.update("update customer_account set amount=? where cust_id=?",
							new Object[] { amount + 2, custId });
					
					//int x = 10 / 0;
					
				} catch (ArithmeticException ae) {
					ae.printStackTrace();
					//status.setRollbackOnly();
					status.rollbackToSavepoint(savePoint);
				}
				return null;
			}

		});

	}

}
