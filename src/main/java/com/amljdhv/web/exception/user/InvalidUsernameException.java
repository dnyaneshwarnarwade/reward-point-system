package com.amljdhv.web.exception.user;

public class InvalidUsernameException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msg;

	public InvalidUsernameException(String message) {
		this.msg = message;
	}
	
	@Override
	public String toString() {
	return this.msg;
	}
	
}
