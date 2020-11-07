package com.beckman.menu;

import java.util.Scanner;

import com.beckman.services.GenerateAccountNumber;
import com.beckman.services.UserInfo;
import com.beckman.services.UserServices;
import com.beckman.users.Customer;
import com.beckman.users.ability.AdminAbility;
import com.beckman.users.ability.CustomerAbility;
import com.beckman.users.ability.EmployeeAbility;

public class Menu {
	
	public static Scanner input = new Scanner(System.in);
	
	public static void mainMenu() {
		System.out.println("Welcome to Who Is The President Bank!");
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
		//if registration is complete send a new application to employee
		boolean registration = true;
		if(registration) {
				System.out.println("Enter Your First Name: ");
				String fname = input.next();
				
				
				System.out.println("Enter Your Last Name: ");
				String lname = input.next();
				
				System.out.println("Create Your Username: ");
				String user = input.next();
				
				//if username already exists
				System.out.println("Create Your Password: ");
				String pass = input.next();
				
				//once new customer is created they receive a random account number
				GenerateAccountNumber acctNum = new GenerateAccountNumber();
				int num = acctNum.Generator();
				Customer c = new Customer(fname, lname, user, pass, num);
				Customer application = c;
				EmployeeAbility.newApplications(application);
				
				//log new customer
				System.out.println(c.getFirstName() + " " + c.getLastName() + " successfully completed their account registation.");
				System.out.println(c.toString());
				System.out.println(UserServices.customerLogin.toString());
				loginMenu();
		}else if(!registration){
			System.out.println("Invalid Entries. Please Try Again.");
			registerMenu();
		}
	
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
					//accountMenu();
				} else {
					System.out.println("Invalid Username And/Or Password. Please Try Again.");
					loginMenu();
				}
				
				//String cu = UserServices.findCustomerLogin(custUsername, custPassword);
				break;
			case 2: 
				System.out.println("Enter Your Username: ");
				String employUsername = input.next();
				
				System.out.println("Enter Your Password: ");
				String employPassword = input.next();
				
				if(UserServices.findEmployeeLogin(employUsername, employPassword) == true) {
					System.out.println("Login Was Successful.");
					//employeeMenu();
				}else {
					System.out.println("Invalid Username And/Or Password. Please Try Again");
					loginMenu();
				}
				
				//String eu = UserServices.findEmployeeLogin(employUsername, employPassword);
				break;
			case 3: 
				System.out.println("Enter Your Username: ");
				String adUsername = input.next();
				
				System.out.println("Enter Your Password: ");
				String adPassword = input.next();
				
				if(UserServices.findAdminLogin(adUsername, adPassword) == true) {
					System.out.println("Login Was Successful");
					//adminMenu();
				} else {
					System.out.println("Invalid Username And/Or Password. Please Try Again.");
					loginMenu();
				}
				
				//String au = UserServices.findAdminLogin(adUsername, adPassword);
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
				//if there are new applications -- review them (toString)
					//if approved print approved & send updates application status to customer upon next login 
					// if !approved print denied & don't change application status for customer
				//if there are no new applications -- print no new apps
				
				if(EmployeeAbility.newApplications() == true) {
					
				}
		}
	}

}
