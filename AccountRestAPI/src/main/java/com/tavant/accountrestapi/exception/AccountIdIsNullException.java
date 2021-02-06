package com.tavant.accountrestapi.exception;

public class AccountIdIsNullException extends Exception {
	private static final long serialVersionUID = 1L;
	public AccountIdIsNullException(String message) {
		super(message);
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+this.getMessage() ;
	}


}
