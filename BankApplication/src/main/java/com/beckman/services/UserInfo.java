package com.beckman.services;

import java.util.ArrayList;
import java.util.List;

import com.beckman.ability.CustomerAbility;
import com.beckman.menu.Menu;
import com.beckman.users.Admin;
import com.beckman.users.Customer;
import com.beckman.users.Employee;


public class UserInfo {
	
	public static List<CustomerAbility> customerAbilityList = new ArrayList<CustomerAbility>();
	

	
	public static List<Customer> customerList = new ArrayList<Customer>();

	public static Customer findCustomerByUsername(String user) {
		for (int i = 0; i < customerList.size(); i++) {
			String custUser = customerList.get(i).getUsername();
			if(user.equals(custUser)) {
				return customerList.get(i);
			}
		}
		return null;
	}
	

	public static Customer findCustomerInfo(String username, String password) {
		
		for(int i = 0; i < customerList.size(); i++ ) {
			String cust = customerList.get(i).toString();
			if(username.equals(cust) && password.equals(cust)) {
					return customerList.get(i);
				}
			}
		System.out.println("Customer Information Not Found. Please Try Again.");
		Menu.loginMenu();
		return null;


	}
	
	
	public static List<Employee> employeeList = new ArrayList<Employee>();
	
	public static Employee findEmployeeInfo(String firstName, String lastName) {
		
		for(int i = 0; i < employeeList.size(); i++ ) {
			Employee empl = employeeList.get(i);
			if(firstName.equals(empl) && lastName.equals(empl)) {
					return employeeList.get(i);
				}
		}
		System.out.println("Employee Information Not Found. Please Try Again.");
		//menu
		return null;
	}
	
	public static List<Admin> adminList = new ArrayList<Admin>();
	
	public static Admin findAdminInfo(String firstName, String lastName) {
		
		for(int i = 0; i < adminList.size(); i++ ) {
			Admin ad = adminList.get(i);
			if(firstName.equals(ad) && lastName.equals(ad)) {
					return adminList.get(i);
			}
		}
		System.out.println("Admin Information Not Found. Please Try Again.");
		//menu
		return null;
	}
}
