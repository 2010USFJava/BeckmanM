package com.beckman.services;


import java.util.HashMap;
import java.util.Map;


import com.beckman.menu.Menu;



public class UserServices extends UserInfo {

		//if login = customer, store login into customer map
		//if login = employee, store login into employee map
		//if login = admin, store login into admin map
		
		//add implementation for if user types a space 	
	
	
	public static Map<String, String> customerLogin = new HashMap<String, String>();
	//public static Map<Customer, Integer> customerAccountAccess = new HashMap<Customer, Integer>();
	
	public static boolean findLogin(String username, String password) {
		if(customerLogin != null) {
			if(customerLogin.containsKey(username)) {
				if((customerLogin.get(username)).equals(password)) {
					return true;
				}
			}
		}
		System.out.println("Customer Login Not Found. Please Try Again.");
		Menu.loginMenu();
		return false;
	}
	

		public static Map<String, String> employeeLogin = new HashMap<String, String>();
		
		public static boolean findEmployeeLogin(String usernameInput, String passwordInput) {
			if(employeeLogin != null) {
				if(employeeLogin.containsKey(usernameInput)) {
					if((employeeLogin.get(usernameInput)).equals(passwordInput)) {
						return true;
					}
				}
			}
			System.out.println("Employee Login Not Found. Please Try Again.");
			Menu.loginMenu();
			return false;
		}
		

		
		public static Map<String, String> adminLogin = new HashMap<String, String>();
		
		
		public static boolean findAdminLogin(String usernameInput, String passwordInput) {
			if(adminLogin != null) {
				if(adminLogin.containsKey(usernameInput)) {
					if((adminLogin.get(usernameInput)).equals(passwordInput)) {
						return true;
					}
				}
			}
			System.out.println("Admin Login Not Found. Please Try Again.");
			Menu.loginMenu();
			return false;
		}
		
		
		
		
//		public static String findAdminLogin(String usernameInput, String passwordInput) {
//			for(Map.Entry<String, String> entry : adminLogin.entrySet()) {
//				String login = adminLogin.getOrDefault(usernameInput, passwordInput);
//				if(usernameInput.equals(entry) && passwordInput.equals(entry)) {
//					return adminLogin.get(entry);
//				}
//			}
//			System.out.println("Admin Login Not Found. Please Try Again");
//			//loginMenu();
//			return null;
//		}
}
