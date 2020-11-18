package com.beckman.driver;

import java.sql.SQLException;

import org.apache.logging.log4j.core.Logger;

import com.beckman.menu.Menu;
import com.beckman.util.FileInfo;
import com.beckman.util.LogInfo;

public class Driver {
	static {FileInfo.readCustomerFile();}
	static {FileInfo.readAdminFile();}
	static {FileInfo.readCustomerLogFile();}
	static {FileInfo.readAdminLogFile();}
	
	public static void main(String[] args) throws SQLException {
		Menu.mainMenu();
//		LogInfo.LogIt("debug", "message");
//		LogInfo.LogIt("info", "log test");
		
			
			
		
		
	}
}
