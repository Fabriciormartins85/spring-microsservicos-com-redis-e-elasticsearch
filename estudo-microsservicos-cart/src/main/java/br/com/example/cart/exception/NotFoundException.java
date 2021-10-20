package br.com.example.cart.exception;

import lombok.Getter;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = -396233009368994460L;

	@Getter
	private final Integer statusCode = 404; 
	
	public NotFoundException() {
	}

	public NotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public NotFoundException(String message) {
		super(message);
	}
}
