package com.hiberus.prueba.exception;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.hiberus.prueba.model.ResponseError;

@ControllerAdvice
@EnableCaching
public class ApiExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ResponseError> runtimeException(RuntimeException e) {
		ResponseError response = new ResponseError();
		response.setCodigoErrorHttp("500");
		response.setMessage(e.getMessage());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);		
	}
	

}
