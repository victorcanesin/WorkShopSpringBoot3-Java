package com.curso.cursospringboot.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.curso.cursospringboot.services.exceptions.DatabaseException;
import com.curso.cursospringboot.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice // <-- vai interceptar as excetion para o objeto realizar os tratamentos
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class) // vai interceptar as exceptions da class ResourceNotFoundException
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException except, 
			HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError standardError = new StandardError(Instant.now(), status.value(), error, except.getMessage(), request.getRequestURI() );
		
		return ResponseEntity.status(status).body(standardError);
		// .status aceita o status que foi criado, body o corpo do erro
	}
	
	
	@ExceptionHandler(DatabaseException.class) // vai interceptar as exceptions da class ResourceNotFoundException
	public ResponseEntity<StandardError> database(DatabaseException except, 
			HttpServletRequest request){
		String error = "Data base error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError standardError = new StandardError(Instant.now(), status.value(), error, except.getMessage(), request.getRequestURI() );
		
		return ResponseEntity.status(status).body(standardError);
		// .status aceita o status que foi criado, body o corpo do erro
	}
	
	
}