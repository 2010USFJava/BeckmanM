package com.beckman.ability;

import com.beckman.menu.Menu;
import com.beckman.services.UserInfo;
import com.beckman.users.Ability;
import com.beckman.users.Customer;
import com.beckman.util.LogInfo;
import com.beckman.users.Ability.AccountType;

public class CustomerAbility implements Ability {
	Customer cust;
	static AccountType acctType;

	public CustomerAbility() {
		super();
		UserInfo.customerAbilityList.add(this);
	}


	public static AccountType getAcctType() {
		return acctType;
	}


	public static void setAcctType(AccountType acctType) {
		CustomerAbility.acctType = acctType;
	}
	
	public static void accountNumber() {
		Customer c = new Customer();
		c.getAccountNumber();
		
	}


	public static void viewBalance(AccountType acctType, Customer cust) {
		double balance = cust.getBalance();
		if(acctType.equals(AccountType.CHECKING)) {
			System.out.println(balance);
		}else if(acctType.equals(AccountType.SAVING)) {
			System.out.println(balance);
		}else if(acctType.equals(AccountType.JOINT)) {
			System.out.println(balance);
		}else {
			System.out.println("Invalid Entry.");
		}
	
	}


	public static void deposit(AccountType acctType, double amount, Customer cust){
		double balance = cust.getBalance();
		double updateBal = 0;
		if(acctType.equals(AccountType.CHECKING)) {
			if(balance >= 0) {
				updateBal = balance + amount;
				LogInfo.LogIt("info", cust.getUsername() + " " + cust.getAccountNumber() + " Successfully Deposited " + amount + " Into " + acctType );
				System.out.println("You Successfully Deposited " + amount + " Into Your " + acctType);
				cust.setBalance(updateBal);
				
			}
		}else if(acctType.equals(AccountType.SAVING)) {
			if(balance >= 0) {
				updateBal = balance + amount;
				balance += amount;
				LogInfo.LogIt("info", cust.getUsername() + " " + cust.getAccountNumber() + " Successfully Deposited " + amount + " Into " + acctType );
				System.out.println("You Successfully Deposited " + amount + " Into Your " + acctType);
				cust.setBalance(updateBal);
			}
		}else if(acctType.equals(AccountType.JOINT)) {
			if(balance >= 0) {
				updateBal = balance + amount;
				LogInfo.LogIt("info", cust.getUsername() + " " + cust.getAccountNumber() + " Successfully Deposited " + amount + " Into " + acctType );
				System.out.println("You Successfully Deposited " + amount + " Into Your " + acctType);
				cust.setBalance(updateBal);
			}
		}else {
			System.out.println("Invalid Entry. Please Try Again.");
			Menu.accountMenu(cust);
		}
	}


	public static void withdraw(AccountType acctType, double amount, Customer cust) {
		double balance = cust.getBalance();
		double updateBal = 0;
			if(acctType.equals(AccountType.CHECKING)) {
				if(balance >= amount) {
					updateBal = balance - amount;
					LogInfo.LogIt("info", cust.getUsername() + " " + cust.getAccountNumber() + " Successfully Withdrew " + amount + " Into " + acctType );
					System.out.println("You Successfully Withdrew " + amount + " From Your " + acctType);
					cust.setBalance(updateBal);
				}
			}else if(acctType.equals(AccountType.SAVING)) {
				if(balance >= amount) {
					updateBal = balance - amount;
					LogInfo.LogIt("info", cust.getUsername() + " " + cust.getAccountNumber() + " Successfully Withdrew " + amount + " Into " + acctType );
					System.out.println("You Successfully Withdrew " + amount + " From Your " + acctType);
					cust.setBalance(updateBal);
				}
			}else if(acctType.equals(AccountType.JOINT)) {
				if(balance >= amount) {
					updateBal = balance - amount;
					LogInfo.LogIt("info", cust.getUsername() + " " + cust.getAccountNumber() + " Successfully Withdrew " + amount + " Into " + acctType );
					System.out.println("You Successfully Withdrew " + amount + " From Your " + acctType);
					cust.setBalance(updateBal);
				}
			}else {
				System.out.println("Insufficient Funds. Please Try Again");
				Menu.accountMenu(cust);
			}
			
		
	}


	public static void transfer(AccountType acctType, AccountType acctType2, double amount, Customer cust) {
		double balance = cust.getBalance();
		double updateBal1 = 0;
		double updateBal2 = 0;
		double otherBalance = cust.getOtherBalance();
		if(acctType.equals(AccountType.CHECKING)) {
			if(acctType2.equals(AccountType.SAVING)) {
				if(balance >= amount && otherBalance >= 0) {
					updateBal1 = balance - amount;
					updateBal2 = otherBalance + amount;
					LogInfo.LogIt("info", cust.getUsername() + " " + cust.getAccountNumber() + " Successfully Transferred " + amount + " From  " + acctType + " To " + acctType2);
					System.out.println("You Successfully Transferred " + amount + " From Your " + acctType + " To Your " + acctType2);
					cust.setBalance(updateBal1);
					cust.setOtherBalance(updateBal2);
				}
			}
		}else if(acctType.equals(AccountType.CHECKING)) {
			if(acctType2.equals(AccountType.JOINT)) {
				if(balance >= amount && otherBalance >= 0) {
					updateBal1 = balance - amount;
					updateBal2 = otherBalance + amount;
					LogInfo.LogIt("info", cust.getUsername() + " " + cust.getAccountNumber() + " Successfully Transferred " + amount + " From  " + acctType + " To " + acctType2);
					System.out.println("You Successfully Transferred " + amount + " From Your " + acctType + " To Your " + acctType2);
					cust.setBalance(updateBal1);
					cust.setOtherBalance(updateBal2);
				}
			}
		}else if(acctType.equals(AccountType.SAVING)) {
			if(acctType2.equals(AccountType.CHECKING)) {
				if(balance >= amount && otherBalance >= 0) {
					updateBal1 = balance - amount;
					updateBal2 = otherBalance + amount;
					LogInfo.LogIt("info", cust.getUsername() + " " + cust.getAccountNumber() + " Successfully Transferred " + amount + " From  " + acctType + " To " + acctType2);
					System.out.println("You Successfully Transferred " + amount + " From Your " + acctType + " To Your " + acctType2);
					cust.setBalance(updateBal1);
					cust.setOtherBalance(updateBal2);
				}
			}
		}else if(acctType.equals(AccountType.SAVING)) {
			if(acctType2.equals(AccountType.JOINT)) {
				if(balance >= amount && otherBalance >= 0) {
					updateBal1 = balance - amount;
					updateBal2 = otherBalance + amount;
					LogInfo.LogIt("info", cust.getUsername() + " " + cust.getAccountNumber() + " Successfully Transferred " + amount + " From  " + acctType + " To " + acctType2);
					System.out.println("You Successfully Transferred " + amount + " From Your " + acctType + " To Your " + acctType2);
					cust.setBalance(updateBal1);
					cust.setOtherBalance(updateBal2);
				}
			}
		}else { 
			System.out.println("Invalid Entry. Please Try Again.");
			Menu.accountMenu(cust);
		}
	}
}
