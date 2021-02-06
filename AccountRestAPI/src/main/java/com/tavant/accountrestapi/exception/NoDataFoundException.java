package com.tavant.accountrestapi.exception;

public class NoDataFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	public NoDataFoundException(String message) {
		super(message);
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+this.getMessage() ;
	}

}
