package com.example.share.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.share.exception.ApiBaseException;
import com.example.share.exception.ErrorDetail;
import com.example.share.exception.NoContentException;
import com.example.share.exception.PasswordIsNotValidException;
import com.example.share.exception.TokenIsExpiredException;
import com.example.share.exception.TokenIsNotValidException;


@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(ApiBaseException.class)
    public ResponseEntity<ErrorDetail> handleApiException(ApiBaseException ex,WebRequest req) {
		String uri = req.getDescription(false);
		if(uri.startsWith("uri=")  ) {
			uri=uri.substring(4);
		}
    	ErrorDetail error=new ErrorDetail(ex.getCode(),uri);
    	
    	return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(PasswordIsNotValidException.class)
    public ResponseEntity<ErrorDetail> handlePasswordIsNotValidExceptions(PasswordIsNotValidException ex,WebRequest req) {
		String uri = req.getDescription(false);
		if(uri.startsWith("uri=")  ) {
			uri=uri.substring(4);
		}
    	ErrorDetail error=new ErrorDetail(ex.getCode(),uri);
    	
    	return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(NoContentException.class)
    public ResponseEntity<ErrorDetail> handleNoContentException(NoContentException ex,WebRequest req) {
    	
		String uri = req.getDescription(false);
		if(uri.startsWith("uri=")  ) {
			uri=uri.substring(4);
		}
    	ErrorDetail error=new ErrorDetail(ex.getCode(),uri);
    	
    	return new ResponseEntity<>(error,HttpStatus.NO_CONTENT);
    }
	
	@ExceptionHandler(TokenIsNotValidException.class)
    public ResponseEntity<ErrorDetail> handleTokenIsNotValidException(TokenIsNotValidException ex,WebRequest req) {
    	
		String uri = req.getDescription(false);
		if(uri.startsWith("uri=")  ) {
			uri=uri.substring(4);
		}
    	ErrorDetail error=new ErrorDetail(ex.getCode(),uri);
    	
    	return new ResponseEntity<>(error,HttpStatus.UNAUTHORIZED);
    }
	
	@ExceptionHandler(TokenIsExpiredException.class)
    public ResponseEntity<ErrorDetail> handleTokenIsExpired(TokenIsExpiredException ex,WebRequest req) {
    	
		String uri = req.getDescription(false);
		if(uri.startsWith("uri=")  ) {
			uri=uri.substring(4);
		}
    	ErrorDetail error=new ErrorDetail(ex.getCode(),uri);
    	
    	return new ResponseEntity<>(error,HttpStatus.UNAUTHORIZED);
    }

	
	
}
