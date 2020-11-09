package com.beckman.driver;

import com.beckman.menu.Menu;
import com.beckman.services.UserInfo;
import com.beckman.services.UserServices;
import com.beckman.users.Employee;
import com.beckman.util.FileInfo;

public class Driver {
	static {FileInfo.readCustomerFile();}
	static {FileInfo.readCustomerFile();}
	static {FileInfo.readAdminFile();}
	static {FileInfo.readCustomerLogFile();}
	static {FileInfo.readEmployeeLogFile();}
	static {FileInfo.readAdminLogFile();}
	
	public static void main(String[] args) {
		Menu.mainMenu();;
		//Menu.employeeMenu();
		//Menu.adminMenu();
		
	
	
		
	}
}
