package io.egen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class CustomerAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 405802649322364762L;

	public CustomerAlreadyExistsException(String message) {
		super(message);
	}

	public CustomerAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}
}
