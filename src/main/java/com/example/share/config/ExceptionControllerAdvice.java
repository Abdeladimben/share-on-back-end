package com.example.share.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.share.exception.ApiBaseException;
import com.example.share.exception.ErrorDetail;


@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ApiBaseException.class)
    public ResponseEntity<ErrorDetail> handleApiException(ApiBaseException ex,WebRequest req) {
    	
    	ErrorDetail error=new ErrorDetail(ex.getCode(),ex.getMessage(),req.getDescription(true));
    	
    	return new ResponseEntity<>(error,ex.getStatus());
    }

}
