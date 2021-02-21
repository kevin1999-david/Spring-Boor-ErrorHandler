package com.bolsaideas.springboot.error.app.errors;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String id) {
		super("User Not Found with id: ".concat(id));
	}
	
	

}
