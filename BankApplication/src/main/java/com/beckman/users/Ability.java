package com.beckman.users;

public abstract interface Ability {
//	public static double checkingBalance = 0;
//	public static double savingBalance = 0;
//	public static double jointBalance = 0;
	public static double amount = 0;
	//public static boolean accountStatus = false;
	public enum AccountType{
		CHECKING,
		SAVING,
		JOINT;
	}
	
	public static void viewBalance(AccountType acctType, Customer cust) {
	}
	public static void deposit(AccountType acctType, double amount, Customer cust) {
	}
	public static void withdraw(AccountType acctType, double amount, Customer cust) {
	}
	public static void transfer(AccountType acctType, AccountType acctType2, double amount, Customer cust) {
	}
}
