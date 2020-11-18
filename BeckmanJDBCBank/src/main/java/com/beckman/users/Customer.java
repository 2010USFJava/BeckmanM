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
	private long custId;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	//private int acctNum = 0; ///add numof acccts later
//	private int numOfAccounts = 0;
//	private boolean accountStatus;
	
	
	public Customer(long custId,String firstName, String lastName, String username, String password) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;

//		this.accountNumber = accountNumber;
//		this.numOfAccounts = numOfAccounts;
//		this.accountStatus = accountStatus;
//		UserInfo.customerList.add(this);
//		UserServices.customerLogin.put(username, password);
	//	GenerateAccountNumber.accountNumbers.contains(accountNumber);
//		FileInfo.writeCustomerFile(UserInfo.customerList);
//	FileInfo.writeCustomerLogFile(UserServices.customerLogin);
	//	LogInfo.LogIt("info", "A new customer, " + this.firstName + " " + this.lastName + " has created a new account!");
	}
	

	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
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
	
	
//
//	public int getAcctNum() {
//		return acctNum;
//	}
//
//
//	public void setAcctNum(int acctNum) {
//		this.acctNum = acctNum;
//	}


	@Override
	public String toString() {
		return "Customer [custId=" + custId + 
				"\n" + "firstName=" + firstName + 
				"\n" + "lastName=" + lastName + 
				"\n" + "username=" + username +
				"\n" + "password=" + password +  "]" +"\n" +"\n";
	}




	

 
	
	
}