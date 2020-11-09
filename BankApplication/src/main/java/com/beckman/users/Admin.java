package com.beckman.users;

import java.io.Serializable;

import com.beckman.services.UserInfo;
import com.beckman.services.UserServices;
import com.beckman.util.FileInfo;
import com.beckman.util.LogInfo;

public class Admin implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6133701720701910620L;
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
		FileInfo.writeAdminFile(UserInfo.adminList);
		FileInfo.writeAdminLogFile(UserServices.adminLogin);
		LogInfo.LogIt("info", "A new admin, " + this.firstName + " " + this.lastName + " has been added to the company!");
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
