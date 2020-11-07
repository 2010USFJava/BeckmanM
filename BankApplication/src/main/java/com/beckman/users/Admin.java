package com.beckman.users;

import com.beckman.services.UserInfo;
import com.beckman.services.UserServices;
import com.beckman.users.ability.AdminAbility;

public class Admin {
	private String firstName;
	private String lastName;
	private String username;
	private String password;
//	Ability ability;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(String firstName, String lastName, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		UserInfo.adminList.add(this);
		UserServices.adminLogin.put(username, password);
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
		return "Admin [firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
	
}
