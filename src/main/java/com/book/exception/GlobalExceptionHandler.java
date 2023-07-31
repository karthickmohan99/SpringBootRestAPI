package com.book.exception;

import java.security.PublicKey;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class GlobalExceptionHandler {
         @ExceptionHandler(value = BookAlreadyExistsExcception.class)
	     @ResponseBody      
	     public ErrorResponse handleAlreadyExistsException(BookAlreadyExistsExcception ex) {
	    	 ErrorResponse response = new ErrorResponse();
	    	 response.setStatusCode(HttpStatus.CONFLICT.value());
	    	 response.setMessage(ex.getMessage());
	    	 return response;
	     }
	     
	         @ExceptionHandler(value = BookNotFoundException.class)
		     @ResponseBody      
		     public ErrorResponse handleBookNotFoundException(BookAlreadyExistsExcception ex) {
		    	 ErrorResponse response = new ErrorResponse();
		    	 response.setStatusCode(HttpStatus.NOT_FOUND.value());
		    	 response.setMessage(ex.getMessage());
		    	 return response;
		     }
		          
	     
  }


