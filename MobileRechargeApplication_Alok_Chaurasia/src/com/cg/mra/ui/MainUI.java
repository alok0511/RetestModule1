package com.cg.mra.ui;

import java.util.Scanner;

import com.cg.mra.beans.Account;
import com.cg.mra.exception.AccountInvalidException;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;

public class MainUI {                                                                      //class begins

	private static Scanner scanner = new Scanner(System.in);
	private static AccountService accountService = new AccountServiceImpl();               //making object of service class

	public static void main(String[] args) throws AccountInvalidException {                //main method begins
		displayMenu();

	}                                                                                      //main method ends

	private static void displayMenu() throws AccountInvalidException {                    //method for displaying menu
		int choice;
		while (true) {
			System.out.println("--------Mobile Recharge Application---------\n");
			System.out.println("Press 1 to Account Balance Enquiry");
			System.out.println("Press 2 to Recharge Account");
			System.out.println("Press 3 to Exit");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			switch (choice) {                                                             //switch case
			case 1:
				accountBalanceEnquiry();
				break;
			case 2:
				rechargeMobileAccount();
				break;
			case 3:
				System.out.println("Successfully Terminated");
				System.exit(0);
				break;
			default:
				System.out.println("You entered the wrong choice");

			}
		}

	}

	private static void accountBalanceEnquiry() throws AccountInvalidException {
		System.out.println("Enter the mobile number to get the account balance enquiry");
		String mobileNumber = scanner.next();                                             //taking mobile number from user
		if (accountService.validateMobileNumber(mobileNumber)) {
			Account account=accountService.getAccountDetails(mobileNumber);
			if(account==null)
				System.err.println("Given Account Id Does Not Exits ");
			else
				System.out.println("Your Current Balance is Rs. "+account.getAccountBalance());
		}
		
		else
			System.out.println("Enter 10 digit mobile number");

	}

	private static void rechargeMobileAccount() throws AccountInvalidException {
		System.out.println("Enter the mobile number you want to recharge");
		String mobileNumber = scanner.next();                                   //taking mobile number from user
		System.out.println("Enter the amount");
		double amount = scanner.nextDouble();                                   //takin amount from user
		if(accountService.validateMobileNumber(mobileNumber))				 												
		{
			if(amount==0){																				
				System.out.println("Recharge amount cannot be zero so please enter amount greater than 0");
			}																							
			else if(accountService.validateRechargeAmount(amount))													
			{
				double updatedBalance=accountService.rechargeAccount(mobileNumber, amount);
				if(updatedBalance==0){																		
				System.err.println("Cannot Recharge Account as Given Mobile Number Does Not Exists ");
				}																						
				else{	
				Account account=accountService.getAccountDetails(mobileNumber);
				System.out.println("Account Recharged Successfully");
				System.out.println("Hello "+account.getCustomerName()+",Available Balance is "+updatedBalance+".");
				}
			}																					
			else
				System.out.println("please enter the valid amount");
		
			}
	}
}                                                                                        //class ends
