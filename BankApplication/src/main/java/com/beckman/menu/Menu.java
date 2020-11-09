 package com.beckman.menu;

import java.util.Scanner;

import com.beckman.ability.AdminAbility;
import com.beckman.ability.CustomerAbility;
import com.beckman.ability.EmployeeAbility;
import com.beckman.services.GenerateAccountNumber;
import com.beckman.services.UserInfo;
import com.beckman.services.UserServices;
import com.beckman.users.Ability;
import com.beckman.users.Ability.AccountType;
import com.beckman.users.Customer;

public class Menu {
	
	public static Scanner input = new Scanner(System.in);
	
	public static void mainMenu() {
		System.out.println("Welcome to IsaBank!");
		System.out.println("Please Select From The Following Options: ");
		System.out.println("\t 1-- If You Want To Register A New Account: Type 1 ");
		System.out.println("\t 2-- If You Already Have An Account: Type 2 ");
		System.out.println("\t 0-- If You Would Like To Leave This App: Type 0 ");
		
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
	
	public static void registerMenu() {
		System.out.println("Register Your Account Here!");
		
		System.out.println("Enter Your First Name: ");
		String fname = input.next();
		input.nextLine();
				
	
		System.out.println("Enter Your Last Name: ");
		String lname = input.next();
		
		System.out.println("Create Your Username: ");
		String user = input.next();
				//if username already exists
				if(user.equals(UserServices.customerLogin.keySet())) {
					System.out.println("Username Is Taken. Please Choose Another Username");
					System.out.println("Create Your Username ");
					String user2 = input.next();
					user = user2;
				}
				
		System.out.println("Create Your Password: ");
		String pass = input.next();
				
				//once new customer is created they receive a random account number
		GenerateAccountNumber acctNum = new GenerateAccountNumber();
		int num = acctNum.Generator();
		Customer c = new Customer(fname, lname, user, pass, num, 0, 0, false);
		System.out.println(c.getFirstName() + " " + c.getLastName() + " successfully completed their account registation.");
		System.out.println(c.toString());
				
		System.out.println("y/n-- Would You Like To Apply For An Account?");
		String apply =input.next();
		if(apply.equalsIgnoreCase("y")) {
			applyMenu();
		}else if(apply.equalsIgnoreCase("n")){
			System.out.println("Thank You For Registering Your Account.");
		}else {
			mainMenu();
		}
		
		System.out.println("Invalid Entries. Please Try Again.");
		registerMenu();
	
	
	}
	
	public static void applyMenu() {
		System.out.println("Select The Type Of Account You Would Like To Apply For: ");
		System.out.println("\t1-- Type 1 For Checking Account");
		System.out.println("\t2-- Type 2 For Savings Account");
		System.out.println("\t3-- Type 3 For Joint Account");
		System.out.println("\t0-- Type 0 To Return To Main Menu");
		int selection = input.nextInt();
		
		switch(selection) {
			case 1:
				CustomerAbility.setAcctType(AccountType.CHECKING);
				System.out.println("You Successfully Applied For A Checking Account");
				break;
			case 2:
				CustomerAbility.setAcctType(AccountType.SAVING);
				System.out.println("You Successfully Applied For A Saving Account");
				break;
			case 3:
				CustomerAbility.setAcctType(AccountType.JOINT);
				System.out.println("You Successfully Applied For A Joint Account");
				break;
			case 0:
				mainMenu();
			default:
				System.out.println("Invalid Entry. Please Try Again");
				applyMenu();
				break;
		}
	loginMenu();
	}
	
	public static void loginMenu() {
		System.out.println("Login");
		System.out.println("Please Select Account Type: ");
		System.out.println("1-- Type 1 For Customer Login");
		System.out.println("2-- Type 2 For Employee Login");
		System.out.println("3-- Type 3 For Admin Login");
		System.out.println("4-- Type 4 To The Main Menu");
		System.out.println("0-- Type 0 To Exit");
		
		int select = input.nextInt();
		switch(select) {
			case 1:
				System.out.println("Enter Your Username: ");
				String custUsername = input.next();
				
				System.out.println("Enter Your Password: ");
				String custPassword = input.next();
				
				if(UserServices.findLogin(custUsername, custPassword) == true) {
					System.out.println("Login Was Successful.");
				} else {
					System.out.println("Invalid Username And/Or Password. Please Try Again.");
					loginMenu();
				}
				Customer cust = UserServices.findCustomerByUsername(custUsername);
				
				accountMenu(cust);
				break;
			case 2: 
				System.out.println("Enter Your Username: ");
				String employUsername = input.next();
				
				System.out.println("Enter Your Password: ");
				String employPassword = input.next();
				
				if(UserServices.findEmployeeLogin(employUsername, employPassword) == true) {
					System.out.println("Login Was Successful.");
					employeeMenu();
				}else {
					System.out.println("Invalid Username And/Or Password. Please Try Again");
					loginMenu();
				}
				break;
			case 3: 
				System.out.println("Enter Your Username: ");
				String adUsername = input.next();
				
				System.out.println("Enter Your Password: ");
				String adPassword = input.next();
				
				if(UserServices.findAdminLogin(adUsername, adPassword) == true) {
					System.out.println("Login Was Successful");
					adminMenu();
				} else {
					System.out.println("Invalid Username And/Or Password. Please Try Again.");
					loginMenu();
				}
				break;
			case 4: 
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
	
	public static void accountMenu(Customer cust) {
		System.out.println("Account Menu");
		System.out.println("\t1-- Type 1 To View Account Balance");
		System.out.println("\t2-- Type 2 To Make A Deposit");
		System.out.println("\t3-- Type 3 To Make A Withdraw");
		System.out.println("\t4-- Type 4 To Make A Transfer");
		System.out.println("\t0-- Type 0 To Logout");
		
		int custInput = input.nextInt();
		switch(custInput) {
			case 1:
				System.out.println("Please Select Which Account Balance You Would Like to View");
				System.out.println("\t1-- Type 1 To View Checking Account Balance");
				System.out.println("\t2-- Type 2 To View Saving Account Balance");
				System.out.println("\t3-- Type 3 To View Joint Account Balance"); //if they have joint account
				System.out.println("\t0-- Type 0 To Go Back To Account Menu");
				if(input.nextInt() == 1) {
					CustomerAbility.viewBalance(AccountType.CHECKING, cust);
				}else if(input.nextInt() == 2) {
					CustomerAbility.viewBalance(AccountType.SAVING, cust);
				}else if(input.nextInt() == 3) {
					CustomerAbility.viewBalance(AccountType.JOINT, cust);
				}else {
					System.out.println("Invalid Entry. Please Try Again.");
					accountMenu(cust);
				}
				accountMenu(cust);
				break;
			case 2:
				System.out.println("Please Select Which Account You Would Like To Deposit Into: ");
				System.out.println("\t1-- Type 1 Checking Account");
				System.out.println("\t2-- Type 2 Saving Account");
				System.out.println("\t3-- Type 3 Joint Account "); //if they have joint account
				System.out.println("\t0-- Type 0 To Go Back To Account Menu");
				if(input.nextInt() == 1) {
					System.out.println("Please Type The Amount You Want To Deposit: ");
					double amountChe = input.nextDouble();
					CustomerAbility.deposit(AccountType.CHECKING, amountChe, cust);
				}else if(input.nextInt() == 2) {
					System.out.println("Please Type The Amount You Want To Deposit: ");
					double amountSav = input.nextDouble();
					CustomerAbility.deposit( AccountType.SAVING, amountSav, cust);
				}else if(input.nextInt() == 3) {
					System.out.println("Please Type The Amount You Want To Deposit: ");
					double amountJoi = input.nextDouble();
					CustomerAbility.deposit(AccountType.JOINT, amountJoi, cust);
				}else if(input.nextInt() == 0) {
					accountMenu(cust);
				}else {
					System.out.println("Invalid Entry. Please Try Again.");
					accountMenu(cust);
				}
				accountMenu(cust);
				break;
			case 3: 
				System.out.println("Please Select Which Account You Would Like To Withdraw From: ");
				System.out.println("\t1-- Type 1 Checking Account");
				System.out.println("\t2-- Type 2 Saving Account");
				System.out.println("\t3-- Type 3 Joint Account "); //if they have joint account
				System.out.println("\t0-- Type 0 To Go Back To Account Menu");
				if(input.nextInt() == 1) {
					System.out.println("Please Type The Amount You Want To Withdraw: ");
					double amountChe = input.nextDouble();
					CustomerAbility.withdraw(AccountType.CHECKING, amountChe, cust);
				}else if(input.nextInt() == 2) {
					System.out.println("Please Type The Amount You Want To Wtihdraw: ");
					double amountSav = input.nextDouble();
					CustomerAbility.withdraw(AccountType.SAVING, amountSav, cust);
				}else if(input.nextInt() == 3) {
					System.out.println("Please Type The Amount You Want To Withdraw: ");
					double amountJoi = input.nextDouble();
					CustomerAbility.withdraw(AccountType.JOINT, amountJoi, cust);
				}else if(input.nextInt() == 0) {
					accountMenu(cust);
				}else {
					System.out.println("Invalid Entry. Please Try Again.");
					accountMenu(cust);
				}
				accountMenu(cust);
				break;
			case 4:
				System.out.println("Please Select Which Account You Would Like To Transfer Money From: ");
				System.out.println("\t1-- Type 1 Checking Account");
				System.out.println("\t2-- Type 2 Saving Account");
				System.out.println("\t3-- Type 3 Joint Account "); //if they have joint account
				System.out.println("\t0-- Type 0 To Go Back To Account Menu");
				int transferFrom = input.nextInt();

				System.out.println("Please Select Which Account You Would Like To Transfer Into: ");
				System.out.println("\t1-- Type 1 Checking Account");
				System.out.println("\t2-- Type 2 Saving Account");
				System.out.println("\t3-- Type 3 Joint Account "); //if they have joint account
				System.out.println("\t0-- Type 0 To Go Back To Account Menu");
				int transferInto = input.nextInt();
				
				System.out.println("Please Enter The Amount You Would Like To Transfer: ");
				double transferAmount = input.nextDouble();
				
				if(transferFrom == 1 && transferInto == 2) {
					CustomerAbility.transfer(AccountType.CHECKING, AccountType.SAVING, transferAmount, cust);
				
				}else if(transferFrom == 2 && transferInto == 1) {
					CustomerAbility.transfer(AccountType.SAVING, AccountType.CHECKING, transferAmount, cust);
					
				}else if(transferFrom == 1 && transferInto == 3) {
					CustomerAbility.transfer(AccountType.CHECKING, AccountType.JOINT, transferAmount, cust);
				
				}else if(transferFrom == 2 && transferInto == 3) {
					CustomerAbility.transfer(AccountType.SAVING, AccountType.JOINT, transferAmount, cust);
					
				}else if(transferFrom == 3 && transferInto == 1) {
					CustomerAbility.transfer(AccountType.JOINT, AccountType.CHECKING, transferAmount, cust);
					
				}else if(transferFrom == 3 && transferInto == 2) {
					CustomerAbility.transfer(AccountType.JOINT, AccountType.SAVING, transferAmount, cust);
				}else {
					System.out.println("Invalid Entry. Please Try Again.");
					accountMenu(cust);
				}
				accountMenu(cust);
				break;
			case 0:
				System.out.println("Logging Out...");
				mainMenu();
				break;
			default:
				System.out.println("Invalid Entry. Please Try Again");
				accountMenu(cust);
				break;
		}
		
	}
	
	
	
	
	public static void employeeMenu() {
		System.out.println("Employee Menu");
		System.out.println("\nSelect From The Following Options: ");
		System.out.println("\t1-- Type 1 To Review New Applications");
		System.out.println("\t2-- Type 2 To View A Customer Account");
		System.out.println("\t0-- Type 0 To Logout");
		
		int option = input.nextInt();
		switch(option) {
			case 1:
				System.out.println("New Applications: ");
				EmployeeAbility.newApplications();
				employeeMenu();
				break;
			case 2:
				EmployeeAbility.viewCustomerAccount();
				employeeMenu();
				break;
			case 0: 
				System.out.println("Logging Out...");
				mainMenu();
			default:
				System.out.println("Invalid Entry. Please Try Again.");
				employeeMenu();
				break;
				
		}
	}
	
	public static void adminMenu() {
		System.out.println("Admin Menu");
		System.out.println("\nSelect From The Following Options: ");
		System.out.println("\t1-- Type 1 To Review Applications");
		System.out.println("\t2-- Type 2 To View Customer Account Information");
		System.out.println("\t3-- Type 3 To Deposit Into Customer Account");
		System.out.println("\t4-- Type 4 To Withdraw From Customer Account");
		System.out.println("\t5-- Type 5 To Transfer From Customer Account");
		System.out.println("\t6-- Type 6 To Delete A Customer Account");
		System.out.println("\t7-- Type 7 To Create A New Employee");
		System.out.println("\t0-- Type 0 To Logout");
		
		int adSelect = input.nextInt();
		switch(adSelect) {
			case 1:
				AdminAbility.newApplications();
				adminMenu();
				break;
			case 2: 
				EmployeeAbility.viewCustomerAccount();
				adminMenu();
				break;
			case 3: 
				AdminAbility.depositCustomer();
				adminMenu();
				break;
			case 4:
				AdminAbility.withdrawCustomer();
				adminMenu();
				break;
			case 5:
				AdminAbility.transferCustomer();
				adminMenu();
				break;
			case 6:
				AdminAbility.deleteCustomer();
				adminMenu();
				break;
			case 7:
				AdminAbility.createNewEmployee();
				adminMenu();
				break;
			case 0:
				System.out.println("Logging Out...");
				mainMenu();
				break;
			default:
				System.out.println("Invalid Entry. Please Try Again.");
				adminMenu();
				break;
		}
	}

}
