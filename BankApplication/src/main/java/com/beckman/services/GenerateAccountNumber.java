package com.beckman.services;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class GenerateAccountNumber {
	
	public static Set<Integer> accountNumbers = new HashSet<Integer>();
	
	public int Generator() {
		int max = 1000000;
		int min = 0100000;
		int randomAcctNum = (int) (Math.random() * (max - min + 1) + min);
		accountNumbers.add(randomAcctNum);
		System.out.println("Your Account Number is: " + randomAcctNum);
		return randomAcctNum;
	}
	
	
	public Integer IterateAccountNumbers(Integer integer) {
		Random random = new Random();
		
		int randomNumber = random.nextInt(accountNumbers.size());
		
		Iterator<Integer> iterator = accountNumbers.iterator();
		
		int currentIndex = 0;
		Integer randomElement = null;
		
		while(iterator.hasNext()) {
			randomElement = iterator.next();
			if(currentIndex == randomNumber) {
				return randomElement;
			}
			currentIndex++;
		}
		return randomElement;
	}
	
}
