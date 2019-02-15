package com.amljdhv.web.exception.phone;

public class InvalidPhoneNumberExeception extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3380898734349264312L;

	
	
	private String msg;
	
	public InvalidPhoneNumberExeception(String message) {
		this.msg = message;
	}

	
	@Override
	public String toString() {
		return this.msg;
	}
}
