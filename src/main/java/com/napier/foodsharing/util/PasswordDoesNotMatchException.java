package com.napier.foodsharing.util;

public class PasswordDoesNotMatchException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;


	public PasswordDoesNotMatchException(String message) {
		 super(message);
	}

}
