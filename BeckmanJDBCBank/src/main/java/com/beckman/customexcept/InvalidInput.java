package com.beckman.customexcept;

public class InvalidInput extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4880659666535017662L;
	public InvalidInput() {
		System.out.println("Invalid Input. Please Try Again.");
	}
}
