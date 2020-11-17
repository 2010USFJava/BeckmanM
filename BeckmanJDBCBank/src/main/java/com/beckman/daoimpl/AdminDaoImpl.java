package com.beckman.daoimpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.beckman.dao.AdminDao;
import com.beckman.users.Account;
import com.beckman.users.Admin;
import com.beckman.users.Ability.AccountType;
import com.beckman.util.ConnFactory;
import com.beckman.util.LogInfo;

public class AdminDaoImpl implements AdminDao{
	public static ConnFactory cf = ConnFactory.getInstance();
			List<Admin> adminList = new ArrayList<Admin>();

	@Override
	public boolean findAdminLogin(String username, String password) throws SQLException{
		Connection conn = cf.getConnection();
		String sql ="select * from admin_empl where ausername=? and apassword=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, username);
		stmt.setString(2, password);
		ResultSet rs = stmt.executeQuery();
		FileInputStream objIn;
		try {
			objIn = new FileInputStream("database.properties");
			Properties p = new Properties();
			p.load(objIn);
			String user = (String) p.getProperty("adminUser");
			String pass = (String) p.getProperty("adminUser");
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
		
		
	}

	@Override
	public List<Admin> getAllAdmin() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select aid, afirst_name, alast_name from admin_empl";//pr select* to show usename and password
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		displayAdmin(rs);
		
		return adminList;
	}

	@Override
	public Admin getAdminById(int id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from admin_empl where aid=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Admin a = null;
		while(rs.next()) {
			a = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5));
		}
		return a;
	}

	@Override
	public void insertNewAdmin(Admin admin, int id, String fname, String lname, String username, String password) throws SQLException {
		String sql = "insert into admin_empl (afirst_name, alast_name, ausername, apassword) values (?,?,?,?)";
		try {
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, admin.getFirstName());
		stmt.setString(2, admin.getLastName());
		stmt.setString(3, admin.getUsername());
		stmt.setString(4, admin.getPassword());
		
		long adId = 0;
		
		int affectedRows = stmt.executeUpdate();
		if(affectedRows > 0) {
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				adId = rs.getLong(1);
				
			}
		}
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public PreparedStatement makePreparedStatement(String s) throws Exception {
		Connection conn = cf.getConnection();
		PreparedStatement pstate = conn.prepareStatement(s);
		return pstate;
	}

	@Override
	public void updateAdmin(Admin admin) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int deleteAdmin(Admin admin, int id) throws SQLException {
		String sql = "delete from admin_empl where aid=?";
		int affectedRows = 0;
		
		try(Connection conn = cf.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)){
			stmt.setInt(1, id);
			affectedRows = stmt.executeUpdate();
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return affectedRows;
	}

	@Override
	public void displayAdmin(ResultSet rs) throws SQLException {
		while(rs.next()) {
			new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			System.out.println(rs.getInt("aid") + "\t"//or is it getString??
					+ rs.getString("afirst_name") 
					+ "\t" + rs.getString("alast_name")
					+ "\t" + rs.getString("ausername") 
					+ "\t" + rs.getString("apassword"));
		}
		
	}

	@Override
	public void viewCustomerAccount() throws SQLException {
		
		
	}

	@Override
	public double depositIntoCustomer(long custId, double amount) throws SQLException {
		return 0;
		
	}

	@Override
	public void withdrawFromCustomer() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferFromCustomer() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newApplications() throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
