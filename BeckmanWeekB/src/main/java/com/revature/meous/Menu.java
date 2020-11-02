package com.revature.meous;

import java.util.Scanner;

import com.revature.beanie.Cat;
import com.revature.list.AdoptionList;
import com.revature.loggy.LogDaCats;

public class Menu {
	static Scanner input = new Scanner(System.in);
	
	public static void mainMenu() {
		System.out.println("Welcome to Cadoption!");
		System.out.println("Please select a number to continue: ");
		System.out.println("\t 1 -- Add a new cat to the adoption list");
		System.out.println("\t 0 -- to exit");
		
		if(input.nextInt() == 1){
			newCatMenu();
		} else if(input.nextInt() == 0) {
			System.out.println("Thnak you! Goodbye!");
		} else {
			System.out.println("Invalid Entry. Please Try Again.");
			mainMenu();
		}
	}
	
	public static void newCatMenu() {
		System.out.println("Add a new cat here!");
		System.out.println("Enter the new cat's name: ");
		String catName = input.nextLine();
		input.nextLine();
		System.out.println("Enter the breed of the cat: ");
		String catBreed = input.nextLine();
		
		System.out.println("Enter the color of the cat's fur: ");
		String catFurColor = input.nextLine();
		
		System.out.println("Enter the gender of the cat:  ");
		String catGender = input.nextLine();
	
		System.out.println("Enter the age of the cat: ");
		int catAge = Integer.parseInt(input.nextLine());
		
		Cat a = new Cat(catName, catBreed, catFurColor, catGender, catAge);
		LogDaCats.LogIt("info", a.getName() +  " was created");
		System.out.println(AdoptionList.adoptionList.toString());
	} 
}
