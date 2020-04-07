package com.luv2code.springdemo.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {
	
	// Add global Controller Exception handeling here!
	
	// Add an exception handler using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException ex) {
		
		StudentErrorResponse theErrorResponse = new StudentErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<>(theErrorResponse, HttpStatus.NOT_FOUND);
	}
	
	// Catch all exception handler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception ex) {
		
		StudentErrorResponse theErrorResponse = new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), System.currentTimeMillis());
		return new ResponseEntity<>(theErrorResponse, HttpStatus.BAD_REQUEST);
	}

}
