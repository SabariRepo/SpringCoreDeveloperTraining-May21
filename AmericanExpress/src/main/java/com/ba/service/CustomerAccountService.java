package com.ba.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ba.dao.CustomerAccountDAO;

@Service
public class CustomerAccountService {

	@Autowired
	CustomerAccountDAO customerAccountDAO;
	
	//Support a current transaction, create a new one if none exists
	@Transactional(readOnly = false ,rollbackFor  = {ArithmeticException.class},propagation = Propagation.REQUIRED)
	public void depositAmount1(int custId, int amount) {
		
		customerAccountDAO.depositAmount1(custId, amount);
	}
}
