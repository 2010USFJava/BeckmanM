package com.revature.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @AllArgsConstructor @NoArgsConstructor @ToString(exclude = "something")
public class Character {
	
	private int id;
	private String charName;
	private String charMotto;
	private Franchise franny;
	
}
