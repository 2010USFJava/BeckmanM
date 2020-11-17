package com.beckman.users;

import java.io.Serializable;

import com.beckman.services.UserInfo;
import com.beckman.services.UserServices;
import com.beckman.util.FileInfo;
import com.beckman.util.LogInfo;

public class Employee implements Serializable{
	/**
	 * 
//	 */
//	private static final long serialVersionUID = 2073640157971750844L;
//	private String firstName;
//	private String lastName;
//	private String username;
//	private String password;
//	//Ability ability;
//	public Employee() {
//		super();
//	}
//	public Employee(String firstName, String lastName, String username, String password) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.username = username;
//		this.password = password;
//		UserInfo.employeeList.add(this);
//		UserServices.employeeLogin.put(username, password);
//		FileInfo.writeEmployeeFile(UserInfo.employeeList);
//		FileInfo.writeEmployeeLogFile(UserServices.customerLogin);
//		LogInfo.LogIt("info", "A new employee, " + this.firstName + " " + this.lastName + " has been added to the company!");
//	}
//	public String getFirstName() {
//		return firstName;
//	}
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//	public String getLastName() {
//		return lastName;
//	}
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	@Override
//	public String toString() {
//		return "Employee [firstName=" + firstName + ", lastName=" + lastName + "]";
//	}
//	
//	
//	
}
