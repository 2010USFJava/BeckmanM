package com.beckman.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.beckman.dao.CustomerDao;
import com.beckman.users.Customer;
import com.beckman.util.ConnFactory;

public class CustomerDaoImpl implements CustomerDao{
	public static ConnFactory cf = ConnFactory.getInstance();
	List<Customer> customerList = new ArrayList<Customer>();

	@Override
	public List<Customer> getAllCustomers() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select  cid, cfirst_name, clast_name from customer";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		displayCustomer(rs);
		return customerList;
	}
	
	@Override
	public boolean findCustomerLogin(String username, String password) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from customer where cusername=? and cpassword=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet rs = stmt.executeQuery();
		Customer c = null;
		while(rs.next()) {
			c = new Customer(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			return true;
		}
		return false;
	
	}
//check
	
	@Override
	public Customer getCustomerById(long custId) throws SQLException {
		
		Connection conn = cf.getConnection();
		String sql = "select * from customer where cid=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setLong(1, custId);
		ResultSet rs = stmt.executeQuery();
		Customer c = null;
		while(rs.next()) {
			c = new Customer(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			
		}
		return c;
	}

	@Override
	public boolean findCustomerByUsername(String username) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from customer where cusername=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, username);
		ResultSet rs = stmt.executeQuery();
		Customer c = null;
		if(rs!=null) {//need?
			while(rs.next()) {
				c = new Customer(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				return true;
			}
		}
		return false;
		
		
	}
	
	

	@Override
	public long insertNewCustomer(Customer cust) throws SQLException {
		
		String sql = "insert into customer values (DEFAULT,?,?,?,?,?)";
			Connection conn = cf.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);//RETURN_GENERATED_KEYS
			stmt.setString(1, cust.getFirstName());
			stmt.setString(2, cust.getLastName());
			stmt.setString(3, cust.getUsername());
			stmt.setString(4, cust.getPassword());
		///	stmt.setInt(5, cust.getAcctNum());
			
			long custId = 0;
			
			int affectedRows = stmt.executeUpdate();
			if(affectedRows > 0) {
			ResultSet rs = stmt.getGeneratedKeys();
					if(rs.next()) {
						custId = rs.getLong(1);
					}	
			}
			return custId;
	}

	@Override
	public int deleteCustomer(String user) throws SQLException {
		String sql = "delete from customer where cusername=?";
		int affectedRows = 0;
		
		Connection conn = cf.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user);
			affectedRows = stmt.executeUpdate();
	
		return affectedRows;
		
	}

	@Override
	public void updateCustomer(Customer cust, int id) throws SQLException {
		// update username??
		//use transaction to update balance stuff??
		
		
	}

	@Override
	public void displayCustomer(ResultSet rs) throws SQLException {
		while(rs.next()) {
			new Customer(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			System.out.println(rs.getString("cfirst_name") 
					+ "\t" + rs.getString("clast_name")
					+ "\t" + rs.getString("cusername") 
					+ "\t" + rs.getString("cpassword"));//probably dont display 
		}
		
	}

	@Override
	public long getCustomerIdByUsername(String username) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select cid from customer where cusername=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, username);
		ResultSet rs = stmt.executeQuery();
		long custId = 0;
		if(rs!=null) {
			while(rs.next()) {
				custId = rs.getInt(1);
				return custId;
			}
		}
		return 0;
	}


}
