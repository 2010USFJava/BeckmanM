package com.beckman.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.beckman.users.Admin;
import com.beckman.users.Customer;
import com.beckman.users.Employee;


public class UserInfo {
	public static enum accountType{
		CUSTOMER,
		EMPLOYEE,
		ADMIN
	}
	
	//Lists of customers, employees, and admins
	//personal information
	

	
	public static List<Customer> customerList = new ArrayList<Customer>();


	
	public static Customer findCustomerInfo(String firstName, String lastName) {
		
		for(int i = 0; i < customerList.size(); i++ ) {
			Customer cust = customerList.get(i);
			if(firstName.equals(cust) && lastName.equals(cust)) {
					return customerList.get(i);
				}
			}
		System.out.println("Customer Information Not Found. Please Try Again.");
		//menu
		return null;


	}
	
	
	public static List<Employee> employeeList = new ArrayList<Employee>();
	
	public static Employee findEmployeeInfo(String firstName, String lastName, accountType accountType) {
		
		for(int i = 0; i < employeeList.size(); i++ ) {
			Employee empl = employeeList.get(i);
			if(firstName.equals(empl) && lastName.equals(empl)) {
				if(accountType.equals(accountType.EMPLOYEE)) {
					return employeeList.get(i);
				}
			}
		}
		System.out.println("Employee Information Not Found. Please Try Again.");
		//menu
		return null;
	}
	
	public static List<Admin> adminList = new ArrayList<Admin>();
	
	public static Admin findAdminInfo(String firstName, String lastName, accountType accountType) {
		
		for(int i = 0; i < adminList.size(); i++ ) {
			Admin ad = adminList.get(i);
			if(firstName.equals(ad) && lastName.equals(ad)) {
				if(accountType.equals(accountType.ADMIN)) {
					return adminList.get(i);
				}
			}
		}
		System.out.println("Admin Information Not Found. Please Try Again.");
		//menu
		return null;
	}
}
