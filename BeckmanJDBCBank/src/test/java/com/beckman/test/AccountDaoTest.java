package com.beckman.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Test;

import com.beckman.daoimpl.AccountDaoImpl;
import com.beckman.daoimpl.CustomerDaoImpl;
import com.beckman.users.Account;
import com.beckman.users.Customer;
import com.beckman.users.Ability.AccountType;
import com.beckman.util.ConnFactory;

public class AccountDaoTest {
	
	static AccountDaoImpl adi = new AccountDaoImpl();
	static CustomerDaoImpl cdi = new CustomerDaoImpl();
	static ConnFactory cf = ConnFactory.getInstance();
	static Connection conn = cf.getConnection();
	
	
	@AfterClass
	public static void testDeleteAccount() {
		Customer c = new Customer(45,"Big", "Tester", "big", "tester");
		Account a = new Account(0,c.getCustId(), AccountType.CHECKING, 0);
		try {
			adi.deleteAccount(a, c.getCustId());
		} catch (SQLException e) {
			System.out.println("delete not working");
			e.printStackTrace();
		}
	}

	@Test
	public void testInsertNewAccount() {
		Customer c = new Customer(45, "Big", "Tester", "big", "tester");
		try {
			cdi.insertNewCustomer(c);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Account a = new Account(0,c.getCustId(), AccountType.CHECKING, 0);
		try {
			adi.insertNewAccount(a, c.getCustId());
		} catch (SQLException e) {
			System.out.println("insert not working");
			e.printStackTrace();
		}
	}
	
	@Test 
	public void testDeposit() {
		Account a = new Account(40, 45, AccountType.CHECKING, 0);
		double amount = 500;
		double newBal = a.getBalance() + amount;
		a.setBalance(newBal);
		double am = 0;
		double expectedBal = 500;
		double actualBal = newBal;
		assertEquals(expectedBal, actualBal, am);
	}
}
