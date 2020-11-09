package com.beckman.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.beckman.users.Customer;

public class AdminTest {
	
	static List<Customer> custList = new ArrayList<>();
	static Customer a =new Customer("Bad", "Egg", "badegg", "999999", 34676, 5000.00, 300.00, true);

	@Test
	public void deleteTest() {
		custList.add(a);
		String user = "badegg";
		
		//find cust by username
		for (int i = 0; i < custList.size(); i++) {
			String cust = custList.get(i).getUsername();
			if(user.equals(cust)) {
				Customer cust2 = custList.remove(i);

						
			}
		}
		
		
	}

}
