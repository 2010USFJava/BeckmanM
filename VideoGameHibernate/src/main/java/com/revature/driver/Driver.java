package com.revature.driver;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Franchise;
import com.revature.models.Character;

public class Driver {
	
	public static void main(String[] args) {
		
		List<Character> cList = new ArrayList<Character>();
		
		Franchise franny = new Franchise(0, "Legend of Zelda", "Nintendo", cList);
		
		Character cranny = new Character(0, "Zelda", "It's Dangerous to Go Alone", franny);
		
		cList.add(cranny);
	}
	
}


