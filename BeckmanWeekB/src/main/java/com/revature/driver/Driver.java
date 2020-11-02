package com.revature.driver;

import com.revature.loggy.FileThoseCats;
import com.revature.meous.Menu;

public class Driver {
	
	static {FileThoseCats.readAdoptionFile();}
	
	public static void main(String[] args) {
		Menu.mainMenu();
		
	}
}
