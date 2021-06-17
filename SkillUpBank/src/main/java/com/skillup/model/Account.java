package com.skillup.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

//Exclusively this acted as a Java Bean - Non Spring Bean - Not Managed By IoC Container
public class Account {

	@Min(value = 100)
	@Max(value = 1000)
	private int accountId;
	
	@NotEmpty
	private String accountName;
	
	private float accountBalance;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public float getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountName=" + accountName + ", accountBalance=" + accountBalance
				+ "]";
	}

	public Account(int accountId, String accountName, float accountBalance) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.accountBalance = accountBalance;
	}
	
	
}
