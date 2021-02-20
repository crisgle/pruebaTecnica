package com.hiberus.prueba.exception;


public class HeroNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 6784059034348382472L;
	
	public HeroNotFoundException(final String message) {
		super(message);
	}

}
