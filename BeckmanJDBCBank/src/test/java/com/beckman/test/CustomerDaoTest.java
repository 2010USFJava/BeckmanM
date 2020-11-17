package com.beckman.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.Test;

import com.beckman.daoimpl.CustomerDaoImpl;
import com.beckman.users.Customer;
import com.beckman.util.ConnFactory;

public class CustomerDaoTest {
	
	static CustomerDaoImpl cdi = new CustomerDaoImpl();
	static ConnFactory cf = ConnFactory.getInstance();
	static Connection conn = cf.getConnection();
	
	@AfterClass
	public static void testDeleteCustomer() {
		try {
			cdi.deleteCustomer("custest");
		} catch (SQLException e) {
			System.out.println("delete not working");
			e.printStackTrace();
		}
	}

	@Test
	public void testInsertNewCustomer() {
		Customer c = new Customer(0,"Mr", "Testing", "custest", "bestcustomer");
		try {
			cdi.insertNewCustomer(c);
			PreparedStatement ps = conn.prepareStatement("select * from customer where user='custest'");
			ResultSet rs = ps.executeQuery();
			Customer cust = null;
			while(rs.next()) {
				cust = new Customer(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				System.out.println(cust.toString());
			}
		} catch (SQLException e) {
			System.out.println("insert not working");
			e.printStackTrace();
		}
	}
	@Test
	public void testFindCustomerUsername() {
		Customer c = new Customer(0,"Mr", "Testing", "custest", "bestcustomer");
		try {
			cdi.insertNewCustomer(c);
			boolean test = false;
			cdi.findCustomerByUsername("custest");
			assertEquals(test, true);
		} catch (SQLException e) {
			System.out.println("CustByUsername problem");
			e.printStackTrace();
		}
	}
	@Test
	public void testGetCustomerByID() {
		Customer c = new Customer(0,"Mr", "Testing", "custest", "bestcustomer");
		try {
			cdi.insertNewCustomer(c);
			long test = 0;
			test = cdi.getCustomerIdByUsername("custest");
			Customer cust = null;
			cust = cdi.getCustomerById(test);
			System.out.println(cust.toString());
			System.out.println(c.toString());
			assertTrue(cust.toString().equals(c.toString()));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			long test = cdi.getCustomerIdByUsername("TestUsertest");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
//	@Test
//	public void testFindCustomerByLogin() {
//		try {
//			cdi.findCustomerLogin("custest", "bestcustomer");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
	

}
