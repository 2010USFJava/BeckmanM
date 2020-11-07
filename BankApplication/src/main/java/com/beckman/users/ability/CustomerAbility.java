package com.beckman.users.ability;

import com.beckman.users.Ability;
import com.beckman.users.Customer;

public class CustomerAbility extends Customer implements Ability  {

	@Override
	public double viewBalance() {
		
		return 0;
	}

	@Override
	public double deposit() {
	
		return 0;
	}

	@Override
	public double withdraw() {
		
		return 0;
	}

	@Override
	public double transfer() {
	
		return 0;
	}

}
