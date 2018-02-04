package ch.flopes.spring.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public String handleGlobalException(Exception e) {
		return "A global error occurred: " + e.getMessage();
	}
}
