package com.beckman.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Test;

import com.beckman.daoimpl.CustomerDaoImpl;
import com.beckman.users.Customer;
import com.beckman.util.ConnFactory;

public class CustomerDaoTest {
	
	static CustomerDaoImpl cdi = new CustomerDaoImpl();
	static ConnFactory cf = ConnFactory.getInstance();
	static Connection conn = cf.getConnection();
//	List<Customer> cList = new ArrayList<>();
	
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
			assertTrue("custest", test=true);
		} catch (SQLException e) {
			System.out.println("CustByUsername problem");
			e.printStackTrace();
		}
	}
	@Test
	public void testGetCustomerByID() {
		Customer c = new Customer(0,"Mr", "Testing", "custest", "bestcustomer");
		try {
			long test = 0;
			test = cdi.insertNewCustomer(c);
			Customer cust = cdi.getCustomerById(test);
			assertEquals("custest", cust.getUsername());
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			long test = cdi.getCustomerIdByUsername("custest");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testFindCustomerByLogin() {
		Customer c = new Customer(0,"Mr", "Testing", "custest", "bestcustomer");
		try {
			long test = 0;
			test = cdi.insertNewCustomer(c);
			boolean t = false;
			Customer cust = cdi.getCustomerById(test);
			cdi.findCustomerLogin("custest", "bestcustomer");
			assertTrue("custest", t=true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void tgetCustomerIdByUsername() {
		Customer c = new Customer(0,"Mr", "Testing", "custest", "bestcustomer");
		try {
			long id = 0;
			cdi.insertNewCustomer(c);
			id = cdi.getCustomerIdByUsername("custest");
			assertEquals("custest", c.getUsername());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testUpdateCustomer() {
		Customer p = new Customer(1, "ttt","ooo", "nay", "1");
		try {
			String newuser = "yay";
			cdi.updateCustomer(p, newuser);
			assertEquals(newuser, p.getUsername());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void tdeleteCustomerById() {
		Customer a = new Customer(0,"t","c","l","u");
		try {
			long id = cdi.insertNewCustomer(a);
			Customer cust = cdi.getCustomerById(id);
			cdi.deleteCustomerById(id);
			assertEquals(id, cust.getCustId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
