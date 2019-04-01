package com.example.springbackend.exception;

public class InvalidRequestTypeException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public InvalidRequestTypeException(String message) {
		
		super(message);
	}

}
