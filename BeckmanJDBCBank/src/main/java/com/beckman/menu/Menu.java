 package com.beckman.menu;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.beckman.daoimpl.AccountDaoImpl;
import com.beckman.daoimpl.AdminDaoImpl;
import com.beckman.daoimpl.CustomerDaoImpl;
import com.beckman.users.Ability.AccountType;
import com.beckman.users.Account;
import com.beckman.users.Customer;
import com.beckman.util.LogInfo;

public class Menu {
	public static CustomerDaoImpl cdi = new CustomerDaoImpl();
	public static AdminDaoImpl adi = new AdminDaoImpl();
	public static AccountDaoImpl bdi = new AccountDaoImpl();
	
	public static Scanner input = new Scanner(System.in);
	
	public static void mainMenu() {
		System.out.println("Welcome to JDBC Bank!");
		System.out.println("Please Select From The Following Options:");
		System.out.println("\t 1-- Register For A New Account");
		System.out.println("\t 2-- Login An Existing Account");
		System.out.println("\t 0-- Leave Application");
		
		int selected  = input.nextInt();
		switch(selected) {
		case 1:
			registerMenu();
			break;
		case 2: 
			loginMenu();
			break;
		case 0:
			System.out.println("Goodbye!");
			break;
		default:
			System.out.println("Invalid Selection. Please Try Again.");
			mainMenu();
			break;
		}
		
	}
	
	public static void registerMenu(){
		System.out.println("Register Your Account Here!");
		
		System.out.println("Enter Your First Name: ");
		String fname = input.next();
		input.nextLine();
				
	
		System.out.println("Enter Your Last Name: ");
		String lname = input.next();
		
		System.out.println("Create Your Username: ");
		String user = input.next();
				//if username already exists
				try {
					if(cdi.findCustomerByUsername(user) == true) {
						System.out.println("Username Is Taken. Please Choose Another Username");
						System.out.println("Create Your Username ");
						String user2 = input.next();
						user = user2;
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
		System.out.println("Create Your Password: ");
		String pass = input.next();
		Customer c = new Customer(0,fname, lname, user, pass);	
		//DaoImpl
		long custId = 0;
		try {
			custId = cdi.insertNewCustomer(c);
			Customer cust = cdi.getCustomerById(custId);
			applyMenu(custId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//log custId
		System.out.println(c.getFirstName() + " " + c.getLastName() + " successfully created a new account!");
		LogInfo.LogIt("info", "Account " + custId + "has been created");
	//	System.out.println(c.toString());
				
//		System.out.println("y/n-- Would You Like To Apply For An Account?");
//		String apply =input.next();
//		if(apply.equalsIgnoreCase("y")) {
//			applyMenu();
//		}else if(apply.equalsIgnoreCase("n")){
//			System.out.println("Thank You For Registering Your Account.");
//		}else {
//			mainMenu();
//		}
		
//		System.out.println("Invalid Entries. Please Try Again.");
//		registerMenu();
	
	
	}
	//every time a new account is created - change cust acctNum
	public static void applyMenu(long custId) {
		System.out.println("Select The Type Of Account You Would Like To Apply For: ");
		System.out.println("\t 1-- Checking Account");
		System.out.println("\t 2-- Savings Account");
		System.out.println("\t 0-- Return To Main Menu");
		int selection = input.nextInt();
		
		Account acct = null;
		long acctId = 0;
		try {
			acctId = bdi.getAccountIdByCustomerId(custId);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		switch(selection) {
			case 1:
				acct = new Account(acctId,custId,AccountType.CHECKING, 0);
				try {
					bdi.insertNewAccount(acct, custId);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				System.out.println("You Successfully Applied For A Checking Account");
				LogInfo.LogIt("info", custId + " cretaed a " + AccountType.CHECKING + " !" );
				break;
			case 2:
				acct = new Account(acctId, custId, AccountType.SAVINGS, 0);
			try {
				bdi.insertNewAccount(acct, custId);
			} catch (SQLException e) {
				e.printStackTrace();
			}
				System.out.println("You Successfully Applied For A Saving Account");
				LogInfo.LogIt("info", custId + " cretaed a " + AccountType.SAVINGS + " !" );
				break;
			case 0:
				mainMenu();
			default:
				System.out.println("Invalid Entry. Please Try Again");
				applyMenu(custId);
				break;
		}
	loginMenu();
	}
	
	public static void loginMenu() {
		System.out.println("Login");
		System.out.println("Please Select Account Type: ");
		System.out.println("\t 1-- Customer Login");
		System.out.println("\t 2-- Admin Login");
		System.out.println("\t 3-- Return To Main Menu");
		System.out.println("\t 0-- Exit");
		
		int select = input.nextInt();
		switch(select) {
			case 1:
				System.out.println("Enter Your Username: ");
				String custUsername = input.next();
				
				System.out.println("Enter Your Password: ");
				String custPassword = input.next();
				long custId = 0;
				try {
					if(cdi.findCustomerLogin(custUsername, custPassword) == true) {
						custId = cdi.getCustomerIdByUsername(custUsername);
						Customer cust = cdi.getCustomerById(custId);
						System.out.println("Login Was Successful");
						LogInfo.LogIt("info", custId + " has logged in.");
						accountMenu(custId);
					} else {
						System.out.println("Invalid Username And/Or Password. Please Try Again.");
						loginMenu();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 2: 
				System.out.println("Enter Your Username: ");
				String adUsername = input.next();
				
				System.out.println("Enter Your Password: ");
				String adPassword = input.next();
				
			try {
				if(adi.findAdminLogin(adUsername, adPassword) == true) {
					System.out.println("Login Was Successful");
					LogInfo.LogIt("info", adUsername + " has logged in.");
					adminMenu();
				} else {
					System.out.println("Invalid Username And/Or Password. Please Try Again.");
					loginMenu();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
				break;
			case 3: 
				mainMenu();
				break;
			case 0:
				System.out.println("Thank You. Goodbye.");
				break;
			default:
				System.out.println("Invalid Entry. Please Try Again.");
				loginMenu();
				break;
		}
	}
	//fix
	public static void accountMenu(long custId) {
		System.out.println("Account Menu");
		System.out.println("\t 1-- View Account Balance");
		System.out.println("\t 2-- Make A Deposit");
		System.out.println("\t 3-- Make A Withdraw");
		System.out.println("\t 4-- Create Another Account");
		System.out.println("\t 5-- Delete Account");
		System.out.println("\t 6-- Edit Username");
		System.out.println("\t 0-- Logout");
		long acctId = 0;
		Account acct = null;
		
		int custInput = input.nextInt();
		switch(custInput) {
			case 1:
				System.out.println("Please Select Which Account Balance You Would Like to View");
				System.out.println("\t1-- Type 1 To View Checking Account Balance");
				System.out.println("\t2-- Type 2 To View Saving Account Balance");
				System.out.println("\t0-- Type 0 To Go Back To Account Menu");
				if(input.nextInt() == 1) {
					try {
						acctId = bdi.getAccountIdByCustomerId(custId);
						acct = bdi.getAccountById(acctId);
						double bal = bdi.viewBalance(acct, AccountType.CHECKING, custId, acctId);
						System.out.println(acctId + " has a balance of " + bal);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}else if(input.nextInt() == 2) {
					try {
						acctId = bdi.getAccountIdByCustomerId(custId);
						acct = bdi.getAccountById(acctId);
						double bal = bdi.viewBalance(acct, AccountType.SAVINGS, custId, acctId);
						System.out.println(acctId + " has a balance of " + bal);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}else {
					System.out.println("Invalid Entry. Please Try Again.");
					accountMenu(custId);
				}
				accountMenu(custId);
				break;
			case 2:
				System.out.println("Please Select Which Account You Would Like To Deposit Into: ");
				System.out.println("\t1-- Type 1 Checking Account");
				System.out.println("\t2-- Type 2 Saving Account");
				System.out.println("\t0-- Type 0 To Go Back To Account Menu");
				if(input.nextInt() == 1) {
					acct = new Account(acctId, custId, AccountType.CHECKING, 0);
					System.out.println("Please Type The Amount You Want To Deposit: ");
					double amountChe = input.nextDouble();
					try {
						acctId = bdi.getAccountIdByCustomerId(custId);
						acct = bdi.getAccountById(acctId);
						double bal = bdi.deposit(acct, amountChe, acctId);
						//System.out.println("You Successfully Deposited " + amountChe + " Into Your " + AccountType.CHECKING);
						//LogInfo.LogIt("info", "AccountId " + acctId + " had deposited " + amountChe + " into their " + AccountType.CHECKING);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}else if(input.nextInt() == 2) {
					acct = new Account(acctId, custId, AccountType.SAVINGS, 0);
					System.out.println("Please Type The Amount You Want To Deposit: ");
					double amountSav = input.nextDouble();
					try {
						acctId = bdi.getAccountIdByCustomerId(custId);
						acct = bdi.getAccountById(acctId);
					double bal = bdi.deposit(acct, amountSav, acctId);
					//System.out.println("You Successfully Depoited " + amountSav + " Into Your " + AccountType.SAVINGS);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}else if(input.nextInt() == 0) {
					accountMenu(custId);
				}else {
					System.out.println("Invalid Entry. Please Try Again.");
					accountMenu(custId);
				}
				accountMenu(custId);
				break;
			case 3: 
				System.out.println("Please Select Which Account You Would Like To Withdraw From: ");
				System.out.println("\t 1-- Checking Account");
				System.out.println("\t 2-- Saving Account");
				System.out.println("\t 0-- Go Back To Account Menu");
				if(input.nextInt() == 1) {
					acct = new Account(acctId, custId, AccountType.CHECKING, 0);
					System.out.println("Please Type The Amount You Want To Withdraw: ");
					double amountChe = input.nextDouble();
					try {
						acctId = bdi.getAccountIdByCustomerId(custId);
						acct = bdi.getAccountById(acctId);
						double bal = bdi.withdraw(acct, AccountType.CHECKING, amountChe, custId, acctId);
					//	System.out.println("You Successfully Withdrew " + amountChe + " From Your " + AccountType.CHECKING);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}else if(input.nextInt() == 2) {
					acct = new Account(acctId, custId, AccountType.SAVINGS, 0);
					System.out.println("Please Type The Amount You Want To Wtihdraw: ");
					double amountSav = input.nextDouble();
					try {
						acctId = bdi.getAccountIdByCustomerId(custId);
						acct = bdi.getAccountById(acctId);
						double bal = bdi.withdraw(acct, AccountType.SAVINGS, amountSav, custId, acctId);
						//System.out.println("You Successfully Withdrew " + amountSav + " From Your " + AccountType.SAVINGS);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}else if(input.nextInt() == 0) {
					accountMenu(custId);
				}else {
					//System.out.println("Invalid Entry. Please Try Again.");
					accountMenu(custId);
				}
				accountMenu(custId);
				break;
			case 4:
				applyMenu(custId);
				break;
			case 5:
			try {
				acctId = bdi.getAccountIdByCustomerId(custId);
				acct = bdi.getAccountById(acctId);
			} catch (SQLException e) {
				e.printStackTrace();
			}
				if(acct.getBalance() != 0) {
					System.out.println("Account Cannot Be Deleted." + "\n" + " Account's Can Only Be Delete If They Are Empty.");
				}else {
					try {
						cdi.deleteCustomerById(acctId);
						LogInfo.LogIt("info", acctId + " has been deleted");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				break;
			case 6:
				System.out.println("Enter Your Old Username: ");
				String old = input.next();
				Customer cust;
				try {
					long id = cdi.getCustomerIdByUsername(old);
					cust = cdi.getCustomerById(id);
					System.out.println("Enter Your New Username: ");
					String user = input.nextLine();
					cdi.updateCustomer(cust, user);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				
				break;
			case 0:
				System.out.println("Logging Out...");
				LogInfo.LogIt("info", custId + " had logged out.");
				mainMenu();
				break;
			default:
				System.out.println("Invalid Entry. Please Try Again");
				accountMenu(custId);
				break;
		}
		
	}
	
	
	
	
	
	public static void adminMenu() {
		System.out.println("			Admin Menu				");
		System.out.println("\nSelect From The Following Options: ");
		System.out.println("\t 1-- View All Customers And Accounts");//fix
		System.out.println("\t 2-- View Customer Account Information");
		System.out.println("\t 3-- Deposit Into Customer Account");
		System.out.println("\t 4-- Withdraw From Customer Account");
		System.out.println("\t 5-- Delete A Customer Account");
		System.out.println("\t 0-- Logout");
		
		int adSelect = input.nextInt();
		switch(adSelect) {
			case 1:
			try {
				List<Customer> cList = cdi.getAllCustomers();
				System.out.println(cList);
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
				break;
			case 2: 
				System.out.println("Enter The Customer ID Of The Account You Want To View: ");
				Long id = input.nextLong();
				try {
					List<Account> acctList = bdi.getAllAccountsFromCust();//does it work?
					System.out.println(acctList);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				adminMenu();
				break;
			case 3:
				System.out.println("Please Enter The Customer ID For Deposit: ");
				long cId = input.nextLong();
				System.out.println("Enter The Deposit Amount: ");
				double amount = input.nextDouble();
				long acctId;
				Account acct;
				AccountType acctType;
				try {
					acctId = bdi.getAccountIdByCustomerId(cId);
					acct = bdi.getAccountById(acctId);
					acctType = bdi.getAcctTypeByAcctId(acctId);
					bdi.deposit(acct, amount, acctId);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				adminMenu();
				break;
			case 4:
				System.out.println("Please Enter The Customer ID For Withdraw: ");
				long cId2 = input.nextLong();
				System.out.println("Enter The Withdraw Amount: ");
				double amount2 = input.nextDouble();
				long acctId2;
				Account acct2;
				AccountType acctType2;
			try {
				acctId2 = bdi.getAccountIdByCustomerId(cId2);
				acct2 = bdi.getAccountById(acctId2);
				acctType2 = bdi.getAcctTypeByAcctId(acctId2);
				bdi.deposit(acct2, amount2, acctId2);
			} catch (SQLException e) {
				e.printStackTrace();
			}
				adminMenu();
				break;
			case 5:
				System.out.println("Please Enter The Customer Id To Delete: ");
				long id3 = input.nextLong();
				Customer cust;
				try {
					cust = cdi.getCustomerById(id3);
					System.out.println(cust.toString());
					System.out.println("Would You Like To Delete This Customer?");
					String del =input.next();
					if(del.equalsIgnoreCase("y")) {
						cdi.deleteCustomerById(id3);
						System.out.println("Customer" + "\n"  + cust.toString() + "Was Deleted");
						adminMenu();
					}else if(del.equalsIgnoreCase("n")){
						System.out.println("Customer " + cust.toString() + " Was Not Deleted");
						adminMenu();
					}else {
						System.out.println("Invalid Entry. Please Try Again");
						adminMenu();
					}
					LogInfo.LogIt("info", cust.toString() + " Was Deleted");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			try {
				adi.deleteCustomer();
			} catch (SQLException e) {
				e.printStackTrace();
			}
				adminMenu();
				break;
			case 0:
				System.out.println("Logging Out...");
				LogInfo.LogIt("info", "Admin had logged out.");
				mainMenu();
				break;
			default:
				System.out.println("Invalid Entry. Please Try Again.");
				adminMenu();
				break;
		}
	}

}
