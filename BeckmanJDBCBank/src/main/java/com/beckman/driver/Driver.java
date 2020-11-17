package com.beckman.driver;

import java.sql.SQLException;

import org.apache.logging.log4j.core.Logger;

import com.beckman.menu.Menu;
import com.beckman.util.FileInfo;

public class Driver {
	static {FileInfo.readCustomerFile();}
	static {FileInfo.readAdminFile();}
	static {FileInfo.readCustomerLogFile();}
	static {FileInfo.readAdminLogFile();}
	
	public static void main(String[] args) throws SQLException {
		Menu.mainMenu();
		//Menu.loginMenu();
			//Menu.registerMenu();
			
//			long custId = 0;
//			CustomerDaoImpl cdi = new CustomerDaoImpl();
//			Customer c = new Customer("test", "tester", "test1", "11111");
//			Customer a = new Customer("NEW", "TEST", "TESTET", "23432");
//			try {
//				custId = cdi.insertNewCustomer(a);
//				System.out.println(custId);
//			}catch(SQLException e) {
//				e.printStackTrace();
//			}
		
			
			
		
		
	}
}
