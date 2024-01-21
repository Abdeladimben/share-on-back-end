package com.example.share.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.share.exception.ApiBaseException;
import com.example.share.exception.ErrorDetail;
import com.example.share.exception.TokenIsExpiredException;
import com.example.share.exception.TokenIsNotValidException;


@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ApiBaseException.class)
    public ResponseEntity<ErrorDetail> handleApiException(ApiBaseException ex,WebRequest req) {
    	
    	ErrorDetail error=new ErrorDetail(ex.getCode(),req.getDescription(true));
    	
    	return new ResponseEntity<>(error,ex.getStatus());
    }
	
	@ExceptionHandler(TokenIsNotValidException.class)
    public ResponseEntity<ErrorDetail> handleTokenIsNotValidException(TokenIsNotValidException ex,WebRequest req) {
    	
    	ErrorDetail error=new ErrorDetail(ex.getCode(),req.getDescription(true));
    	
    	return new ResponseEntity<>(error,HttpStatus.UNAUTHORIZED);
    }
	
	@ExceptionHandler(TokenIsExpiredException.class)
    public ResponseEntity<ErrorDetail> handleTokenIsExpired(TokenIsExpiredException ex,WebRequest req) {
    	
    	ErrorDetail error=new ErrorDetail(ex.getCode(),req.getDescription(true));
    	
    	return new ResponseEntity<>(error,HttpStatus.UNAUTHORIZED);
    }

	
	
}
