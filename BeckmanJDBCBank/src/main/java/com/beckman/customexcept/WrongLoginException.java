package com.beckman.customexcept;

public class WrongLoginException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2857842213731643986L;
	public WrongLoginException() {
		System.out.println("Invalid Username And/Or Password. Please Try Again");
	}
}
