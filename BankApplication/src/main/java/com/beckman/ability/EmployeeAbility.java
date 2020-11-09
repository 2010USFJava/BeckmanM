package com.beckman.ability;

import java.util.Scanner;


import com.beckman.services.UserInfo;
import com.beckman.users.Customer;

import com.beckman.util.LogInfo;

public class EmployeeAbility  {
	
	static Scanner input = new Scanner(System.in);

	
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
	
	public static void viewCustomerAccount() {
		System.out.println("Please Enter Customer Username You Would Like To View: ");
		System.out.println(UserInfo.customerList);
		String custUsername = input.nextLine();
		UserInfo.findCustomerByUsername(custUsername);
		
		
		
	}
}


