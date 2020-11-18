package com.beckman.users;



public class Account implements Ability{
	private long acctId;
	private long custId;
	private double balance;

	public AccountType acctType;
	
	public Account(long acctId, long custId, AccountType acctType, double balance) {
		super();
		this.acctId = acctId;
		this.custId = custId;
		this.acctType = acctType;
		this.balance = balance;
	}
	
	
	
	public long getAcctId() {
		return acctId;
	}



	public void setAcctId(long acctId) {
		this.acctId = acctId;
	}



	public long getCustId() {
		return custId;
	}

	public void setCustId(long custId) {
		this.custId = custId;
	}

	public AccountType getAcctType() {
		return acctType;
	}
	public  void setAcctType(AccountType acctType) {
		this.acctType = acctType;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}



	@Override
	public String toString() {
		return "Account [acctId=" + acctId + ", custId=" + custId + ", balance=" + balance + ", acctType=" + acctType
				+ "]";
	}


	
	
}
