package com.beckman.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.beckman.dao.AccountDao;
import com.beckman.users.Ability.AccountType;
import com.beckman.users.Account;
import com.beckman.users.Customer;
import com.beckman.util.ConnFactory;
import com.beckman.util.LogInfo;

public class AccountDaoImpl implements AccountDao{
	
	public static ConnFactory cf = ConnFactory.getInstance();
	List<Account> accountList = new ArrayList<Account>();
	@Override
	public List<Account> getAllAccounts() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from account";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		displayAccount(rs);
		return accountList;
	}
	@Override
	public Account getAccountById(long id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from account where cid=?";
		PreparedStatement  stmt = conn.prepareStatement(sql);
		stmt.setLong(1, id);
		ResultSet rs = stmt.executeQuery();
		Account a = null;
		while(rs.next()) {
			a = new Account(rs.getLong(1), rs.getLong(2), AccountType.valueOf(rs.getString(3)), rs.getDouble(4));
			//long acctId = rs.getLong()
		}
		return a;
	}
	@Override
	public long insertNewAccount(Account acct, long id) throws SQLException {
		String enumType = acct.getAcctType().toString();
		
		String sql ="insert into account values (DEFAULT,?,?,?)";
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setLong(1, id);
		stmt.setString(2, enumType);
		stmt.setDouble(3, 0);
		
		long acctId = 0;
		int affectedRow = stmt.executeUpdate();
		if(affectedRow > 0) {
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				acctId = rs.getLong(1);
			}
			
		}
		
		return acctId;
	}
	@Override
	public long deleteAccount(Account acct, long id) throws SQLException {
		String sql = "delete from where cid=?";
		int affectedRows = 0;
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setLong(1, acct.getCustId());
		affectedRows = stmt.executeUpdate();;
		return affectedRows;
	}
	@Override
	public void updateAccount(Account acct, int id) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public double viewBalance(Account acct, AccountType acctType, long custId, long acctId) throws SQLException {
		String sql = "select * from account where cid=?";
		Connection conn = cf.getConnection();
		PreparedStatement stmt;
		stmt = conn.prepareStatement(sql);
		stmt.setDouble(1, custId);
		ResultSet rs = stmt.executeQuery();
		Account a;
		while(rs.next()) {
			a = new Account(rs.getLong(1), rs.getLong(2), AccountType.valueOf(rs.getString(3)), rs.getDouble(4));
			double 	balance = rs.getDouble(4);
			return balance;
		}	
		double balance = acct.getBalance();
		if(acctType.equals(AccountType.CHECKING)) {
			return balance;
		}else if(acctType.equals(AccountType.SAVING)) {
//			acct.setBalance(balance);
			return balance;
		}
		return 0;
		
	}
	@Override
	public double deposit(Account acct, AccountType acctType, double amount, long custId) throws SQLException {
		String sql = "select * from account where cid=?";
		Connection conn = cf.getConnection();
		String enumType = acct.getAcctType().toString();
		PreparedStatement stmt;
			stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, custId);
			ResultSet rs = stmt.executeQuery();
			Account a;
			while(rs.next()) {
				a = new Account(rs.getLong(1), rs.getLong(2), AccountType.valueOf(rs.getString(3)), rs.getDouble(4));
			double 	b =  a.getBalance();
			return b;
			}	
		double balance = acct.getBalance();
		double updateBal = 0;
		if(acctType.equals(AccountType.CHECKING)) {
			if(balance >= 0) {
				updateBal = balance + amount;
				acct.setBalance(updateBal);
				LogInfo.LogIt("info", "Account number " + acct.getCustId()  +  " Successfully Deposited " + amount + " Into " + acctType );
				System.out.println("You Successfully Deposited " + amount + " Into Your " + acctType);
			}
		}else if(acctType.equals(AccountType.SAVING)) {
			if(balance >= 0) {
				updateBal = balance + amount;
				acct.setBalance(updateBal);
				LogInfo.LogIt("info", "Account number " + acct.getCustId()  +  " Successfully Deposited " + amount + " Into " + acctType );
				System.out.println("You Successfully Deposited " + amount + " Into Your " + acctType);
			}
		}else {
			System.out.println("Invalid Entry. Please Try Again.");
		}
		String sql2= "update account set balance=balance+? where cid=?";
		int affectedRows = 0;
		Connection conn2 = cf.getConnection();
		PreparedStatement stmt2 = conn2.prepareStatement(sql2);
			stmt.setDouble(1, amount);
			stmt.setLong(2, custId);
			affectedRows = stmt.executeUpdate();
		return affectedRows;
		
	}
	@Override
	public double withdraw(Account acct, AccountType acctType, double amount, long custId) throws SQLException{
		String sql = "select * from account where cid=?";
		Connection conn = cf.getConnection();
		String enumType = acct.getAcctType().toString();
		PreparedStatement stmt;
			stmt = conn.prepareStatement(sql);
			stmt.setDouble(1, custId);
			ResultSet rs = stmt.executeQuery();
			Account a;
			while(rs.next()) {
				a = new Account(rs.getLong(1), rs.getLong(2), AccountType.valueOf(rs.getString(3)), rs.getDouble(4));
			double 	b =  a.getBalance();
			return b;
			}		
		
		double balance = acct.getBalance();
		double updateBal = 0;
			if(acctType.equals(AccountType.CHECKING)) {
				if(balance >= amount) {
					updateBal = balance - amount;
					acct.setBalance(updateBal);
					LogInfo.LogIt("info", acct.getCustId() + " Successfully Withdrew " + amount + " Into " + acctType );
					System.out.println("You Successfully Withdrew " + amount + " From Your " + acctType);
				}
			}else if(acctType.equals(AccountType.SAVING)) {
				if(balance >= amount) {
					updateBal = balance - amount;
					acct.setBalance(updateBal);
					LogInfo.LogIt("info", acct.getCustId() + " Successfully Withdrew " + amount + " Into " + acctType );
					System.out.println("You Successfully Withdrew " + amount + " From Your " + acctType);
				}
			}else {
				System.out.println("Invalid Entry. Please Try Agian.");
			}
		String sql2 = "update account set balance=? where cid=?";
		int affectedRows = 0;
		Connection conn2 = cf.getConnection();
		PreparedStatement stmt2;
			stmt2 = conn2.prepareStatement(sql2);
			stmt2.setDouble(1, amount);
			stmt2.setLong(2, custId);
			affectedRows = stmt2.executeUpdate();
		return affectedRows;
		
	}

	@Override
	public void transfer(AccountType acctType, AccountType acctType2, double amount, long custId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void viewAccount(int id) throws SQLException {
		
		
	}
	@Override
	public void multipleDeposits() throws SQLException {
		String sql = "begin; update account set balance=balance-? where cusername=? savepoint my_savpoint;"
				+ "update account set balance=balance+? where cusername=? commit;";
//		BEGIN;
//		UPDATE accounts SET balance = balance - 100.00
//		    WHERE name = 'Alice';
//		SAVEPOINT my_savepoint;
//		UPDATE accounts SET balance = balance + 100.00
//		    WHERE name = 'Bob';
//		-- oops ... forget that and use Wally's account
//		ROLLBACK TO my_savepoint;
//		UPDATE accounts SET balance = balance + 100.00
//		    WHERE name = 'Wally';
//		COMMIT;
		
	}
	@Override
	public void displayAccount(ResultSet rs) throws SQLException {
		while(rs.next()) {
			new Account(rs.getLong(1), rs.getLong(2), AccountType.valueOf(rs.getString(3)), rs.getDouble(4));
			System.out.println(rs.getString("cfirst_name") 
					+ "\t" + rs.getString("clast_name")
					+ "\t" + rs.getString("cusername") 
					+ "\t" + rs.getString("cpassword"));//probably dont display 
		}
		
	}

	@Override
	public long getAccountIdByCustomerId(long id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select acct_id from account where cid=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setLong(1, id);
		ResultSet rs = stmt.executeQuery();
		long acctId = 0;
		if(rs!=null) {
			while(rs.next()) {
				acctId = rs.getLong(1);
				return acctId;
			}
		}
		return 0;
	}
	@Override
	public AccountType getAcctTypeByAcctId(long id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select acct_type from account where acct_id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setLong(1, id);
		ResultSet rs = stmt.executeQuery();
		AccountType at = null;
		if(rs!=null) {
			while(rs.next()) {
				at = AccountType.valueOf(rs.getString(3));
				return at;
			}
		}
		return null;
	}

	

}
