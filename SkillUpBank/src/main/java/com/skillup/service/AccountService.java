package com.skillup.service;

import java.util.List;

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
	
	public List<Account> findAllAccountDetails(){
		return accountDAO.findAllAccountDetails();
	}
	
	public void accountBatchUpdate() {
		accountDAO.accountBatchUpdate();
	}
	
	public void callgetAccountProc() {
		accountDAO.callgetAccountProc();
	}
}
