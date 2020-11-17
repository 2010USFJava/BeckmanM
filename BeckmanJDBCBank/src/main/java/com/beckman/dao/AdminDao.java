package com.beckman.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.beckman.users.Admin;

public interface AdminDao {
	public boolean findAdminLogin(String username, String password) throws SQLException;
	public void newApplications() throws SQLException;
	public void viewCustomerAccount() throws SQLException;
	public double depositIntoCustomer(long custId, double amount) throws SQLException;
	public void withdrawFromCustomer() throws SQLException;
	public void transferFromCustomer() throws SQLException;
	public void deleteCustomer() throws SQLException;
	
	
	public PreparedStatement makePreparedStatement(String s) throws Exception;
	
	public Admin getAdminById(int id) throws SQLException;
	public List<Admin> getAllAdmin() throws SQLException;
	public void insertNewAdmin(Admin admin, int adminId, String fname, String lname,
			String username, String password) throws SQLException; //maybe just admin param
	public void updateAdmin(Admin admin) throws SQLException;
	public int deleteAdmin(Admin admin, int id) throws SQLException;
	void displayAdmin(ResultSet rs) throws SQLException;
}
