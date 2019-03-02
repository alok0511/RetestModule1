package com.cg.mra.exception;

public class AccountInvalidException extends Exception {                     //exception class

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "AccountInvalidException";
	}

	public AccountInvalidException(String msg) {
		super(msg);
	}

}
