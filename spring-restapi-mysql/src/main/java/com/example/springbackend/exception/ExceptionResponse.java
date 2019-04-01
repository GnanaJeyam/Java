package com.example.springbackend.exception;

import java.util.Date;

public class ExceptionResponse {

	private String message;
	private Date date;
	
	public ExceptionResponse() {
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getMessage() {
		return message;
	}

	public Date getDate() {
		return date;
	}
	
}
