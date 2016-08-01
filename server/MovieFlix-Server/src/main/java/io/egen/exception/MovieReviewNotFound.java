package io.egen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class MovieReviewNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public MovieReviewNotFound(String message) {
		super(message);
	}

	public MovieReviewNotFound(String message, Throwable cause) {
		super(message, cause);
	}
}
