package com.tavant.accountrestapi.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotFoundException extends Exception
{
	private static final long serialVersionUID = 1L;
	public NotFoundException(String message) {
		super(message);
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+this.getMessage() ;
	}

}
