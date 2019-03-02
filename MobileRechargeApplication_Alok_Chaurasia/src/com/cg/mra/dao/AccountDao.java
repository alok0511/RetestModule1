package com.cg.mra.dao;

import com.cg.mra.beans.Account;                                   //importing Account class

public interface AccountDao {                                      //interface

	public Account getAccountDetails(String mobileNo);

	public double rechargeAccount(String mobileNo, double rechargeAmount);

}
