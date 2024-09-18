package com.thewa.hotel.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.io.Serial;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HttpRatingServiceNotFound extends HttpClientErrorException {
	@Serial
	private static final long serialVersionUID=1L;
	public HttpRatingServiceNotFound(HttpStatusCode statusCode) {
		super(statusCode);
	}
}