package com.ssafy.myhome.exception.advice;

public class IllegalUserException extends RuntimeException {
	private static final long serialVersionUID = -2238030302650813813L;
	
	public IllegalUserException() {
		super();
	}

	public IllegalUserException(String message) {
		super(message);
	}

	public IllegalUserException(String message, Throwable cause) {
		super(message, cause);
	}

	public IllegalUserException(Throwable cause) {
		super(cause);
	}
}
