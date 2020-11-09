package com.beckman.users;

import java.io.Serializable;

import com.beckman.services.GenerateAccountNumber;
import com.beckman.services.UserInfo;
import com.beckman.services.UserServices;
import com.beckman.util.FileInfo;
import com.beckman.util.LogInfo;

public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2473381849471430776L;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private double balance;
	private double otherBalance;
	private int accountNumber;
	private boolean accountStatus;
	//CustomerAbility
	
	
	public Customer() {
		super();
	}
	public Customer(String firstName, String lastName, String username, String password, int accountNumber, double balance, double otherBalance, boolean accountStatus) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.otherBalance = otherBalance;
		this.accountNumber = accountNumber;
		this.accountStatus = accountStatus;
		UserInfo.customerList.add(this);
		UserServices.customerLogin.put(username, password);
		GenerateAccountNumber.accountNumbers.contains(accountNumber);
		FileInfo.writeCustomerFile(UserInfo.customerList);
		FileInfo.writeCustomerLogFile(UserServices.customerLogin);
		LogInfo.LogIt("info", "A new customer, " + this.firstName + " " + this.lastName + " has created a new account!");
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
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getOtherBalance() {
		return otherBalance;
	}
	public void setOtherBalance(double otherBalance) {
		this.otherBalance = otherBalance;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public boolean isAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(boolean accountStatus) {
		this.accountStatus = accountStatus;
	}
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", username=" + username + ", password="
				+ password + ", balance=" + balance + ", otherBalance=" + otherBalance + ", accountNumber="
				+ accountNumber + ", accountStatus=" + accountStatus + "]";
	}
	

 
	
	
}