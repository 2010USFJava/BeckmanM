package com.beckman.test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.beckman.users.Customer;

public class CustomerAbilityTest {
	
	static Customer a;
	static Customer b;
	
	@BeforeClass
	public static void initialSetUp(){
		System.out.println("Testing");
	}
	@Before
	public void runBeforeEachTest() {
		System.out.println("Running Before Each Test!");
	}

	@Test
	public void depositTest() {
		a = new Customer("Jack", "Jones", "jjone", "jones1", 125373, 0, 0, false);
		double amount = 3000.00;
		double bal = a.getBalance();
		double bal2 = 0;
		if(bal >= 0) {
			bal2 = bal + amount;
			a.setBalance(amount);
		}
	}
	
	public void withdrawTest() {
		b = new Customer("Jill", "Jones", "jilly", "jones2", 654273, 35000.00, 0, false);
		double amount = 4000.30;
		double bal = b.getBalance();
		double bal2 = 0;
		if(bal == amount) {
			bal2 = bal - amount;
			b.setBalance(bal2);
		}
		
	}
	
	public void transferTest() {
		double amount = 500.50;
		double aBal = a.getBalance();
		double bBal = b.getBalance();
		double aNewBal = 0;
		double bNewBal = 0;
		if(aBal >= amount && bBal >= 0) {
			aNewBal = aBal - amount;
			aNewBal = aBal + amount;
			a.setBalance(aNewBal);
			b.setBalance(bNewBal);
		}
		
	}
	
	

}
