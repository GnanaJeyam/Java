package com.example.springbackend.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler(InvalidRequestTypeException.class)
	public ResponseEntity<ExceptionResponse> handleException(InvalidRequestTypeException exception) {
		
		ExceptionResponse exceptionResponse =  new ExceptionResponse();
		  exceptionResponse.setDate(new Date());
		  exceptionResponse.setMessage(exception.getMessage());
		
		return new ResponseEntity<ExceptionResponse>( exceptionResponse,
			HttpStatus.BAD_REQUEST );
		
	}
}
