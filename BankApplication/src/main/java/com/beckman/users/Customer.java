package com.beckman.users;

import com.beckman.services.GenerateAccountNumber;
import com.beckman.services.UserInfo;
import com.beckman.services.UserServices;

public class Customer {
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private int accountNumber;
	//Ability ability;
	
	public Customer() {
		super();
	}
	public Customer(String firstName, String lastName, String username, String password, int accountNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.accountNumber = accountNumber;
		UserInfo.customerList.add(this);
		UserServices.customerLogin.put(username, password);
		GenerateAccountNumber.accountNumbers.contains(accountNumber);
		//maybe will work?? if admin or employee search for the number to find customer information
		//log
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password="
				+ password + ", accountNumber=" + accountNumber + "]";
	}
 
	
	
}