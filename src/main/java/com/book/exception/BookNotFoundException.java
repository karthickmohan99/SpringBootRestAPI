package com.book.exception;

import org.hibernate.bytecode.internal.bytebuddy.PrivateAccessorException;

public class BookNotFoundException extends RuntimeException {
	
	private String message;
	
	public BookNotFoundException(String message) {
		super(message);
		this.message=message;
	}
	

}
