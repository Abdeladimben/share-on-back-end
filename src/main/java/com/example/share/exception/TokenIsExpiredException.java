package com.example.share.exception;

import org.springframework.http.HttpStatus;

import com.example.share.enums.ErrorCode;

public class TokenIsExpiredException extends ApiBaseException{

	public TokenIsExpiredException(String message, ErrorCode errorCode, HttpStatus httpStatus) {
		super(message, errorCode, httpStatus);
		// TODO Auto-generated constructor stub
	}
	
	public TokenIsExpiredException(String message, ErrorCode errorCode) {
		super(message, errorCode);
		// TODO Auto-generated constructor stub
	}
	
	public TokenIsExpiredException(ErrorCode errorCode) {
		super(errorCode);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ErrorCode getCode() {
		// TODO Auto-generated method stub
		return super.errorCode;
	}

	@Override
	public HttpStatus getStatus() {
		// TODO Auto-generated method stub
		return httpStatus;
	}

}
