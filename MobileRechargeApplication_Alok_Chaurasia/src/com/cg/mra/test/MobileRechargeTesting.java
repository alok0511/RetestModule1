package com.cg.mra.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cg.mra.exception.AccountInvalidException;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;

public class MobileRechargeTesting {
	AccountService accountService;

	@Before
	public void setUp() throws Exception {
		accountService = new AccountServiceImpl();
	}

	/*
	 * When the correct details are given by the user.
	 * 
	 */

	@Test
	public void whenTheCorrectAccountDetailsAreInputted() throws AccountInvalidException {
		boolean result = accountService.validateMobileNumber("8808965596");
		assertEquals(true, result);

	}

	/*
	 * When the correct recharge amount is entered by the user.
	 * 
	 * 
	 */

	@Test
	public void whenTheCorrectRechargeAmountIsEntered() throws AccountInvalidException {
		boolean result = accountService.validateRechargeAmount(150);
		assertEquals(true, result);

	}

	/*
	 * When the mobile number entered by the user does not exist.
	 * 
	 */

	@Test(expected = AccountInvalidException.class)
	public void whenTheUserAccountDoesNotExistItShouldThrowAnException() throws AccountInvalidException {
		accountService.validateMobileNumber(null);
	}

	/*
	 * When the user entered mobile number is greater than 10 digit then it
	 * should throw an exception
	 * 
	 * 
	 */

	@Test
	public void ValidateMobileNumber_v5() throws AccountInvalidException {
		boolean result = accountService.validateMobileNumber("973180356789");
		assertEquals(false, result);

	}
}
