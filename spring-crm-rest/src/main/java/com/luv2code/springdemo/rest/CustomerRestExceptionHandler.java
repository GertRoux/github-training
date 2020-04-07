package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {
	
	// Add global Controller Exception handeling here!
	
	// Add an exception handler using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(CustomerNotFoundException ex) {
		
		CustomerErrorResponse theErrorResponse = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<>(theErrorResponse, HttpStatus.NOT_FOUND);
	}
	
	// Catch all exception handler
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleException(Exception ex) {
		
		CustomerErrorResponse theErrorResponse = new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<>(theErrorResponse, HttpStatus.BAD_REQUEST);
	}

}
