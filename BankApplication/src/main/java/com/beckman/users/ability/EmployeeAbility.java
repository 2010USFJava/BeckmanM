package com.beckman.users.ability;

import java.util.HashMap;
import java.util.Map;

import com.beckman.services.GenerateAccountNumber;
import com.beckman.users.Ability;
import com.beckman.users.Customer;
import com.beckman.users.Employee;

public class EmployeeAbility extends Employee implements Ability {
	
	public static void newApplications(Customer customer) {
		System.out.println("New Application Received: " + customer.toString());
		boolean approved = true;
		if(approved) {
			//active bank account
			System.out.println("Application Has Been Approved");
		} else if(!approved) {
			System.out.println("Application Has Been Rejected.");
		}
	}
	
	public static void getCustomerInfo(int custAccountNum) {
		if(GenerateAccountNumber.accountNumbers.contains(custAccountNum)) {
			//get customer info and customer's transaction history
		}
	}



	@Override
	public double viewBalance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double deposit() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double withdraw() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double transfer() {
		// TODO Auto-generated method stub
		return 0;
	}

}
