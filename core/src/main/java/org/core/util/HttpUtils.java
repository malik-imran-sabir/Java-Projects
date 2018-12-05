package org.core.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HttpUtils {

	
	
	public static <E> ResponseEntity<E> getResponseEntity(E response, HttpStatus status) {
		return new ResponseEntity<E>(response, status);
	}
}
