package com.beckman.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.beckman.users.Account;
import com.beckman.users.Customer;
import com.beckman.users.Ability.AccountType;


public interface AccountDao {
	public List<Account> getAllAccounts() throws SQLException;
	public Account getAccountById(long id) throws SQLException;
	public long getAccountIdByCustomerId(long id) throws SQLException;
	public AccountType getAcctTypeByAcctId(long id) throws SQLException;
	public long insertNewAccount(Account acct, long id) throws SQLException;
	public long deleteAccount(Account acct, long id) throws SQLException;
	public void updateAccount(Account acct, int id) throws SQLException;
	public void viewAccount(int id) throws SQLException;
	public void multipleDeposits() throws SQLException;
	public List<Account> getAllAccountsFromCust() throws SQLException;
	
	public double viewBalance(Account acct, AccountType acctType, long custId, long acctId) throws SQLException;
	public double deposit(Account acct, double amount, long acctId) throws SQLException;
	public double withdraw(Account acct, AccountType acctType, double amount, long custId, long acctId) throws SQLException;
	public void transfer(AccountType acctType, AccountType acctType2, double amount, long custId);
	void displayAccount(ResultSet rs) throws SQLException;
}
