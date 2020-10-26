package com.revature.bank;

public class Customer {
	private String username;
	private String password;
	
	private double balance;
	
	public Customer() {
		
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



	//register new usernames and password
	//apply to open account - can apply for joint accounts
	
	//customer can withdraw, deposit, & transfer between accounts
	//make sure they are not able to put a negative amounts or overdraw
	
	//private username and password information 
	//maybe make the class abstract ?
	
	//employees can also be customers 


}
