package com.beckman.ability;

import java.util.Scanner;

import com.beckman.services.UserInfo;
import com.beckman.services.UserServices;
import com.beckman.users.Ability.AccountType;
import com.beckman.users.Customer;
import com.beckman.users.Employee;
import com.beckman.util.LogInfo;

public class AdminAbility extends EmployeeAbility {
	
	static Scanner input = new Scanner(System.in);
	
	public static void createNewEmployee() {
		System.out.println("Employee First Name");
		String fname = input.nextLine();
		System.out.println("Employee Last Name");
		String lname = input.nextLine();
		System.out.println("Employee Username");
		String username = input.nextLine();
		System.out.println("Employee Password");
		String password = input.nextLine();
		
		Employee e = new Employee(fname, lname, username, password);
		UserInfo.employeeList.add(e);
		UserServices.employeeLogin.containsKey(e.getUsername());
		UserServices.employeeLogin.containsValue(e.getPassword());
		LogInfo.LogIt("info", e.getFirstName() + e.getLastName() + " Has Been Added To Employee");
	}
	
	public static void depositCustomer() {
		System.out.println("Please Enter Customer Account Number You Would Like To Deposit To: ");
		System.out.println(UserInfo.customerList);
		String custUsername = input.nextLine();
		System.out.println("Enter The Deposit Amount: ");
		double amount = input.nextDouble();
		Customer cust = UserInfo.findCustomerByUsername(custUsername);
		CustomerAbility.deposit(AccountType.CHECKING, amount, cust);
		
	}
	
	public static void withdrawCustomer() {
		System.out.println("Please Enter Customer Account Number You Would Like To Withdraw From: ");
		System.out.println(UserInfo.customerList);
		String custUsername = input.nextLine();
		Customer cust = UserInfo.findCustomerByUsername(custUsername);
		System.out.println("Enter The Withdraw Amount: ");
		double amount = input.nextDouble();
		double balance = cust.getBalance();
		double updateBal = 0;
		if(balance >= amount) {
			updateBal = balance - amount;
			cust.setBalance(updateBal);
		}else {
			System.out.println("Insufficient Funds. Please Try Again.");
			withdrawCustomer();
		}
	}
	
	public static void transferCustomer() {
		System.out.println("Please Enter Customer Username You Would Like To Transfer From: ");
		System.out.println(UserInfo.customerList);
		String custUsername = input.nextLine();
		Customer cust = UserInfo.findCustomerByUsername(custUsername);
		System.out.println("Enter The Transfer Amount: ");
		double amount = input.nextDouble();
		double balance = cust.getBalance();
		double otherBalance = cust.getOtherBalance();
		double updateBal1 = 0;
		double updateBal2 = 0;
		if(balance >= amount && otherBalance >= 0) {
			updateBal1 = balance - amount;
			updateBal2 = otherBalance + amount;
			cust.setBalance(updateBal1);
			cust.setOtherBalance(updateBal2);
		}else {
			System.out.println("Insufficient Funds. Please Try Again.");
			transferCustomer();
		}
	}
	
	public static void deleteCustomer() {
		System.out.println("Please Enter Customer Username You Would Like To Delete: ");
		System.out.println(UserInfo.customerList);
		String custUsername = input.nextLine();
		Customer cust = UserInfo.findCustomerByUsername(custUsername);
		UserInfo.customerList.remove(cust);
		UserServices.customerLogin.remove(custUsername);
		LogInfo.LogIt("info", cust.toString() + " Was Deleted");
		System.out.println(cust.toString() + " Was Deleted.");
		System.out.println(UserInfo.customerList);
	}
	
	public static void newApplications() {
		for (int i = 0; i < UserInfo.customerList.size(); i++) {
			Customer cust = UserInfo.customerList.get(i);
			if(cust.isAccountStatus() == false) {
				System.out.println("New Account Appliction " + (i+1) + cust);
				cust.toString();
				System.out.println("y/n-- Would You Like To Approve This Account?");
				String approved = input.nextLine();
					if(approved.equalsIgnoreCase("y")) {
						cust.setAccountStatus(true);
						System.out.println("This Account Has Been Approved.");
						LogInfo.LogIt("info", cust.getUsername() + " " + cust.getAccountNumber() + " Has Been Approved.");
					}else if(approved.equalsIgnoreCase("n")) {
						System.out.println("This Account Has Been Denied");
						LogInfo.LogIt("info", cust.getUsername() + " " + cust.getAccountNumber() + " Has Been Denied");
			}
		}
	}
}

	
}
