package com.beckman.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import com.beckman.users.Customer;

public interface CustomerDao {
	public boolean findCustomerLogin(String username, String password) throws SQLException;
	public boolean findCustomerByUsername(String username) throws SQLException;
	public long getCustomerIdByUsername(String username) throws SQLException;
	public List<Customer> getAllCustomers() throws SQLException;
	public Customer getCustomerById(long custId) throws SQLException;
	public long insertNewCustomer(Customer cust) throws SQLException;
	public int deleteCustomer(String user) throws SQLException;
	public void updateCustomer(Customer cust, int id) throws SQLException;
	void displayCustomer(ResultSet rs) throws SQLException;
}
