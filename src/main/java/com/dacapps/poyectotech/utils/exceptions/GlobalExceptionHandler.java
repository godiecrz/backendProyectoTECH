package com.dacapps.poyectotech.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handlerArgumentException(IllegalArgumentException ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handlerRuntimeException(RuntimeException ex){
		return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_GATEWAY);
	}
	
	// Cuando las credenciales son incorrectas
	@ExceptionHandler(CredentialsException.class)
    public ResponseEntity<String> handleCredentialsException(CredentialsException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }
	
	//Cuando se intenta registrar un usuario con el mismo email
	@ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<Object> handleUserAlreadyExistsEcxception(UserAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }
	
}
