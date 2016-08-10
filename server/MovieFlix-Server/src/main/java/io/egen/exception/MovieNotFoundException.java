package io.egen.exception;

public class MovieNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -1118771158183783993L;

	public MovieNotFoundException(String message) {
		super(message);
	}

	public MovieNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}
