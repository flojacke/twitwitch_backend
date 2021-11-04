package com.frey.quitter.exception;

public class SpringQuitterException extends RuntimeException {

	public SpringQuitterException(String exMessage) {
		super(exMessage);
	}
	
	public SpringQuitterException(String exMessage, Exception exception) {
		super(exMessage, exception);
	}
}
