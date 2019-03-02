package com.cg.mra.service;

import com.cg.mra.beans.Account;
import com.cg.mra.exception.AccountInvalidException;

public interface AccountService {                                 // interface

	public Account getAccountDetails(String mobileNo);

	public double rechargeAccount(String mobileNo, double rechargeAmount);

	public boolean validateMobileNumber(String mobileNo) throws AccountInvalidException;          //validation function of mobile number

	public boolean validateRechargeAmount(double rechargeAmount) throws AccountInvalidException;       //validation function of recharge amount

}
