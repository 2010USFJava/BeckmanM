 package com.beckman.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.beckman.services.UserInfo;
import com.beckman.services.UserServices;
import com.beckman.users.Admin;
import com.beckman.users.Customer;
import com.beckman.users.Employee;

public class FileInfo {
	
	public static final String customerFile = "customerList.txt";
	
	//add text file for customer transactions???
	
	public static void writeCustomerFile(List<Customer> cList) {
		try {
			ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(customerFile));
			objOut.writeObject(cList);
			objOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void readCustomerFile() {
		try {
			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(customerFile));
			UserInfo.customerList = (ArrayList<Customer>)objIn.readObject();
			objIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static final String customerLogFile = "customerLogMap.txt";
	
	public static void writeCustomerLogFile(Map<String,String> custLog) {
		try {
			ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(customerLogFile));
			objOut.writeObject(custLog);
			objOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
	public static void readCustomerLogFile() {
		try {
			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(customerLogFile));
			UserServices.customerLogin = (Map<String,String>)objIn.readObject();
			objIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static final String employeeFile = "employeeList.txt";
	
	public static void writeEmployeeFile(List<Employee> eList) {
		try {
			ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(employeeFile));
			objOut.writeObject(eList);
			objOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void readEmployeeFile() {
		try {
			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(employeeFile));
			UserInfo.employeeList = (ArrayList<Employee>)objIn.readObject();
			objIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
public static final String employeeLogFile = "employeeLogMap.txt";
	
	public static void writeEmployeeLogFile(Map<String,String> emplLog) {
		try {
			ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(employeeLogFile));
			objOut.writeObject(emplLog);
			objOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
	public static void readEmployeeLogFile() {
		try {
			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(employeeLogFile));
			UserServices.employeeLogin = (Map<String,String>)objIn.readObject();
			objIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public static final String adminFile = "adminList.txt";
	
	public static void writeAdminFile(List<Admin> aList) {
		try {
			ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(adminFile));
			objOut.writeObject(aList);
			objOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void readAdminFile() {
		try {
			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(adminFile));
			UserInfo.adminList = (ArrayList<Admin>)objIn.readObject();
			objIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
public static final String adminLogFile = "adminLogMap.txt";
	
	public static void writeAdminLogFile(Map<String,String> adLog) {
		try {
			ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream(adminLogFile));
			objOut.writeObject(adLog);
			objOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@SuppressWarnings("unchecked")
	public static void readAdminLogFile() {
		try {
			ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(adminLogFile));
			UserServices.adminLogin = (Map<String,String>)objIn.readObject();
			objIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	

}
