package com.cognizant.expenseSeverity.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global Exception Handler class
 */
@RestControllerAdvice
public class GlobalExceptionHandler {


	/**
	 * Handles user name numeric exception
	 * 
	 * @param ex
	 * @return This returns the custom error message and the time stamp and the HTTP
	 *         status code
	 */
	@ExceptionHandler(InvalidChoiceException.class)
	public ResponseEntity<CustomErrorResponse> handlesUserNotFoundException(
			InvalidChoiceException invalidChoiceException) {
		CustomErrorResponse response = new CustomErrorResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(invalidChoiceException.getMessage());

		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
