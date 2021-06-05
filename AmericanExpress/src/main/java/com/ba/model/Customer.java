package com.ba.model;
//POJO - Java Bean
public class Customer {

	private int customerId;
	private String custmomerName;
	private String customerAddress;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(int customerId, String custmomerName, String customerAddress) {
		this.customerId = customerId;
		this.custmomerName = custmomerName;
		this.customerAddress = customerAddress;
	}
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustmomerName() {
		return custmomerName;
	}

	public void setCustmomerName(String custmomerName) {
		this.custmomerName = custmomerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", custmomerName=" + custmomerName + ", customerAddress="
				+ customerAddress + "]";
	}

	
	
	
}
