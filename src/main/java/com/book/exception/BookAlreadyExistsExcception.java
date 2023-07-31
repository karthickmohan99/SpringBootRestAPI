package com.book.exception;

public class BookAlreadyExistsExcception extends RuntimeException{
	String message;
	public BookAlreadyExistsExcception(String message) {
		super(message);
		this.message=message;
		
	}

}
