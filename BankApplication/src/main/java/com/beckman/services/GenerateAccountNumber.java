package com.beckman.services;

import java.util.HashSet;
import java.util.Set;

import com.beckman.menu.Menu;

public class GenerateAccountNumber extends UserInfo {
	
	public static Set<Integer> accountNumbers = new HashSet<Integer>();
	
	public int Generator() {
		int max = 1000000;
		int min = 0100000;
		int randomAcctNum = (int) (Math.random() * (max - min + 1) + min);
		if(accountNumbers.contains(randomAcctNum)) {
			Generator();
		}else {
			accountNumbers.add(randomAcctNum);
		}
		System.out.println("Your Account Number is: " + randomAcctNum);
		return randomAcctNum;
	}
	
	
	public static Integer findAccountNumber(Integer integer) {
		if(accountNumbers.contains(integer)) {
			for(Integer i : accountNumbers) {
				if(integer.equals(i) && customerList.equals(i)) {
					return i;
				}
			}
		}
		System.out.println("Account number Not Found. Please Try Again.");
		Menu.employeeMenu();
		return null;
	}
	
	
}
