package com.heraizen.pms.tms.service;

public class AlreadyUserExistsException extends Exception {
	private static final long serialVersionUID = 5320348162832887936L;
	public String message="user Already registered with given email or username";
	public AlreadyUserExistsException(String message) {
		super(message);
		
	}
	public AlreadyUserExistsException() {
		super("user Already registered with given email or username");
		
	}
	

}
