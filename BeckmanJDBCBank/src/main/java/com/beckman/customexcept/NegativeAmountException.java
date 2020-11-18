package com.beckman.customexcept;

public class NegativeAmountException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -648005738118875944L;
	public NegativeAmountException() {
		System.out.println("Negavtive Amounts Not Accepted.");
	}
}
