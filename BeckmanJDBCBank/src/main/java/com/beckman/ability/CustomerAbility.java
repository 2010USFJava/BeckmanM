package com.beckman.ability;

import com.beckman.menu.Menu;
import com.beckman.services.UserInfo;
import com.beckman.services.UserServices;
import com.beckman.users.Ability;
import com.beckman.users.Account;
import com.beckman.users.Customer;
import com.beckman.util.FileInfo;
import com.beckman.util.LogInfo;

public class CustomerAbility implements Ability {
//	Account acct;
//
//	public static void viewBalance(AccountType acctType, Account acct, double balance) {
//		//double balance = cust.getBalance();
//		if(acctType.equals(AccountType.CHECKING)) {
//			System.out.println(balance);
//		}else if(acctType.equals(AccountType.SAVING)) {
//			System.out.println(balance);
//		}else if(acctType.equals(AccountType.JOINT)) {
//			System.out.println(balance);
//		}else {
//			System.out.println("Invalid Entry.");
//		}
//	
//	}
//
//
//	public static void deposit(AccountType acctType, double amount, Account acct){
//		double balance = acct.getBalance();
//		double updateBal = 0;
//		if(acctType.equals(AccountType.CHECKING)) {
//			if(balance >= 0) {
//				updateBal = balance + amount;
//				acct.setBalance(updateBal);
//				LogInfo.LogIt("info", cust.getUsername() + " " + cust.getAccountNumber() + " Successfully Deposited " + amount + " Into " + acctType );
//				FileInfo.writeCustomerFile(UserServices.customerList);
//				System.out.println("You Successfully Deposited " + amount + " Into Your " + acctType);
//				
//			}
//		}else if(acctType.equals(AccountType.SAVING)) {
//			if(balance >= 0) {
//				updateBal = balance + amount;
//				acct.setBalance(updateBal);
//				LogInfo.LogIt("info", cust.getUsername() + " " + cust.getAccountNumber() + " Successfully Deposited " + amount + " Into " + acctType );
//				FileInfo.writeCustomerFile(UserServices.customerList);
//				System.out.println("You Successfully Deposited " + amount + " Into Your " + acctType);
//			}
//		}else if(acctType.equals(AccountType.JOINT)) {
//			if(balance >= 0) {
//				updateBal = balance + amount;
//				acct.setBalance(updateBal);
//				LogInfo.LogIt("info", cust.getUsername() + " " + cust.getAccountNumber() + " Successfully Deposited " + amount + " Into " + acctType );
//				FileInfo.writeCustomerFile(UserServices.customerList);
//				System.out.println("You Successfully Deposited " + amount + " Into Your " + acctType);
//			}
//		}else {
//			System.out.println("Invalid Entry. Please Try Again.");
//			Menu.accountMenu(cust);
//		}
//	}
//
//
//	public static void withdraw(AccountType acctType, double amount, Customer cust) {
//		double balance = acct.getBalance();
//		double updateBal = 0;
//			if(acctType.equals(AccountType.CHECKING)) {
//				if(balance >= amount) {
//					updateBal = balance - amount;
//					acct.setBalance(updateBal);
//					LogInfo.LogIt("info", cust.getUsername() + " " + cust.getAccountNumber() + " Successfully Withdrew " + amount + " Into " + acctType );
//					FileInfo.writeCustomerFile(UserServices.customerList);
//					System.out.println("You Successfully Withdrew " + amount + " From Your " + acctType);
//				}
//			}else if(acctType.equals(AccountType.SAVING)) {
//				if(balance >= amount) {
//					updateBal = balance - amount;
//					acct.setBalance(updateBal);
//					LogInfo.LogIt("info", cust.getUsername() + " " + cust.getAccountNumber() + " Successfully Withdrew " + amount + " Into " + acctType );
//					FileInfo.writeCustomerFile(UserServices.customerList);
//					System.out.println("You Successfully Withdrew " + amount + " From Your " + acctType);
//				}
//			}else if(acctType.equals(AccountType.JOINT)) {
//				if(balance >= amount) {
//					updateBal = balance - amount;
//					acct.setBalance(updateBal);
//					LogInfo.LogIt("info", cust.getUsername() + " " + cust.getAccountNumber() + " Successfully Withdrew " + amount + " Into " + acctType );
//					FileInfo.writeCustomerFile(UserServices.customerList);
//					System.out.println("You Successfully Withdrew " + amount + " From Your " + acctType);
//				}
//			}else {
//				System.out.println("Insufficient Funds. Please Try Again");
//				Menu.accountMenu(cust);
//			}
//			
//		
//	}
//
//	//fix so customer has to apply for joint and saving then connect though accounts to balances
//	public static void transfer(AccountType acctType, AccountType acctType2, double amount, Customer cust) {
//		double balance = acct.getBalance();
//		double updateBal1 = 0;
//		double updateBal2 = 0;
//		double otherBalance = acct.getOtherBalance();
//		if(acctType.equals(AccountType.CHECKING)) {
//			if(acctType2.equals(AccountType.SAVING)) {
//				if(balance >= amount && otherBalance >= 0) {
//					updateBal1 = balance - amount;
//					updateBal2 = otherBalance + amount;
//					acct.setBalance(updateBal1);
//					acct.setOtherBalance(updateBal2);
//					LogInfo.LogIt("info", cust.getUsername() + " " + cust.getAccountNumber() + " Successfully Transferred " + amount + " From  " + acctType + " To " + acctType2);
//					FileInfo.writeCustomerFile(UserServices.customerList);
//					System.out.println("You Successfully Transferred " + amount + " From Your " + acctType + " To Your " + acctType2);
//				}
//			}
//		}else if(acctType.equals(AccountType.CHECKING)) {
//			if(acctType2.equals(AccountType.JOINT)) {
//				if(balance >= amount && otherBalance >= 0) {
//					updateBal1 = balance - amount;
//					updateBal2 = otherBalance + amount;
//					acct.setBalance(updateBal1);
//					acct.setOtherBalance(updateBal2);
//					LogInfo.LogIt("info", cust.getUsername() + " " + cust.getAccountNumber() + " Successfully Transferred " + amount + " From  " + acctType + " To " + acctType2);
//					FileInfo.writeCustomerFile(UserServices.customerList);
//					System.out.println("You Successfully Transferred " + amount + " From Your " + acctType + " To Your " + acctType2);
//				}
//			}
//		}else if(acctType.equals(AccountType.SAVING)) {
//			if(acctType2.equals(AccountType.CHECKING)) {
//				if(balance >= amount && otherBalance >= 0) {
//					updateBal1 = balance - amount;
//					updateBal2 = otherBalance + amount;
//					cust.setBalance(updateBal1);
//					cust.setOtherBalance(updateBal2);
//					LogInfo.LogIt("info", cust.getUsername() + " " + cust.getAccountNumber() + " Successfully Transferred " + amount + " From  " + acctType + " To " + acctType2);
//					FileInfo.writeCustomerFile(UserServices.customerList);
//					System.out.println("You Successfully Transferred " + amount + " From Your " + acctType + " To Your " + acctType2);
//				}
//			}
//		}else if(acctType.equals(AccountType.SAVING)) {
//			if(acctType2.equals(AccountType.JOINT)) {
//				if(balance >= amount && otherBalance >= 0) {
//					updateBal1 = balance - amount;
//					updateBal2 = otherBalance + amount;
//					cust.setBalance(updateBal1);
//					cust.setOtherBalance(updateBal2);
//					LogInfo.LogIt("info", cust.getUsername() + " " + cust.getAccountNumber() + " Successfully Transferred " + amount + " From  " + acctType + " To " + acctType2);
//					FileInfo.writeCustomerFile(UserServices.customerList);
//					System.out.println("You Successfully Transferred " + amount + " From Your " + acctType + " To Your " + acctType2);
//				}
//			}
//		}else if(acctType.equals(AccountType.JOINT) && acctType2.equals(AccountType.CHECKING)){ 
//			if(balance >= amount && otherBalance >= 0) {
//				updateBal1 = balance - amount;
//				updateBal2 = otherBalance + amount;
//				cust.setBalance(updateBal1);
//				cust.setOtherBalance(updateBal2);
//				LogInfo.LogIt("info", cust.getUsername() + " " + cust.getAccountNumber() + " Successfully Transferred " + amount + " From  " + acctType + " To " + acctType2);
//				FileInfo.writeCustomerFile(UserServices.customerList);
//				System.out.println("You Successfully Transferred " + amount + " From Your " + acctType + " To Your " + acctType2);
//			}
//		}else if(acctType.equals(AccountType.JOINT) && acctType2.equals(AccountType.SAVING)) {
//			if(balance >= amount && otherBalance >= 0) {
//				updateBal1 = balance - amount;
//				updateBal2 = otherBalance + amount;
//				cust.setBalance(updateBal1);
//				cust.setOtherBalance(updateBal2);
//				LogInfo.LogIt("info", cust.getUsername() + " " + cust.getAccountNumber() + " Successfully Transferred " + amount + " From  " + acctType + " To " + acctType2);
//				FileInfo.writeCustomerFile(UserServices.customerList);
//				System.out.println("You Successfully Transferred " + amount + " From Your " + acctType + " To Your " + acctType2);
//				
//			}
//		}else {
//			System.out.println("Invalid Entry. Please Try Again.");
//			Menu.accountMenu(cust);
//		}
//	}
}
