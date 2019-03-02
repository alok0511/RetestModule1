package com.cg.mra.beans;

public class Account {                                         //class begins

	private String mobileNo;                                   //variable declaration
	private String accountType;
	private String customerName;
	private double accountBalance;

	public Account(String accountType, String customerName, double accountBalance) {             //parameterized constructor
		super();
		this.accountType = accountType;
		this.customerName = customerName;
		this.accountBalance = accountBalance;
	}

	public String getMobileNo() {                                                //getter and setters
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

}                                                                               //class ends
