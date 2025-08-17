package com.example.demo.globalexceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.demo.exception.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	 @ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex)
	{
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
}
