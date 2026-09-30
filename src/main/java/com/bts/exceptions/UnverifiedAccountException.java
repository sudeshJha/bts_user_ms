package com.bts.exceptions;

public class UnverifiedAccountException extends RuntimeException{
	public UnverifiedAccountException(String message) {
        super(message);
    }
}
