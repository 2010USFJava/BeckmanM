package com.beckman.customexcept;

public class UsernameAlreadyExists extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9004097522672823408L;
	public UsernameAlreadyExists() {
		System.out.println("Username Already Exists. Please Try Again.");
	}
}
