package com.skillup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillup.dao.AccountDAO;
import com.skillup.model.Account;
import com.skillup.util.AccountIDNotFoundException;

@Service
public class AccountService {

	@Autowired
	AccountDAO accountDAO;
	
	public boolean addAccount(Account account) {
		return accountDAO.addAccount(account);
	}
	
	public Account findByAccountId(int accountId)throws AccountIDNotFoundException {
		return accountDAO.findByAccountId(accountId);
	}
}
