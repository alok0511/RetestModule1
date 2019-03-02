package com.cg.mra.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.mra.beans.Account;
import com.cg.mra.dao.AccountDao;
import com.cg.mra.dao.AccountDaoImpl;
import com.cg.mra.exception.AccountInvalidException;

public class AccountServiceImpl implements AccountService {        //implementation of the account service interface
	AccountDao accountDao;

	public AccountServiceImpl() {                                  //constructor
		super();
		accountDao = new AccountDaoImpl();
	}

	@Override
	public Account getAccountDetails(String mobileNo) {

		return accountDao.getAccountDetails(mobileNo);
	}

	@Override
	public double rechargeAccount(String mobileNo, double rechargeAmount) {

		return accountDao.rechargeAccount(mobileNo, rechargeAmount);
	}

	public boolean validateMobileNumber(String mobileNo) throws AccountInvalidException {         //validating mobile number
		if(mobileNo == null){
			throw new AccountInvalidException("Mobile Number cannot be null");                   //mobile number cannot be null
		}
		Pattern pattern = Pattern.compile("[6-9]{1}[0-9]{2,9}");
		Matcher matcher = pattern.matcher(mobileNo);
		return matcher.matches();

	}

	public boolean validateRechargeAmount(double rechargeAmount) throws AccountInvalidException {      //validating recharge amount
		if (rechargeAmount > 0) {
			return true;
		}
		throw new AccountInvalidException("Recharge amount must be greater than 0 ");
	}
}
