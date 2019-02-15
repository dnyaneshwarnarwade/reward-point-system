package com.amljdhv.web.exception.email;

public class InvalidEmailException extends RuntimeException{
	
	
	private static final long serialVersionUID = -7069029111653775409L;
	private String msg;
	
	public InvalidEmailException(String message) {
		
		this.msg = message;
	}
	
	@Override
	public String toString() {
		return this.msg;
	}

	
}
