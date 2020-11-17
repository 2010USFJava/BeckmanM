package com.beckman.users;

public interface Ability {

	public static double amount = 0;
	public enum AccountType{
		CHECKING("CHECKING"),
		SAVING("SAVINGS");
		private String aType;
		private AccountType(String string) {
			this.aType = string;
		}
		@Override 
		public String toString() {
			return aType;
		}
	}
	

}
