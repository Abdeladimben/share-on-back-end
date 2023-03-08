package com.example.share.exception;

import org.springframework.http.HttpStatus;

import com.example.share.enums.ErrorCode;

public class NotFoundException extends ApiBaseException{

	ErrorCode errorCode;
	
	public NotFoundException(String message,ErrorCode errorCode,HttpStatus httpStatus) {
		super(message,errorCode, httpStatus);
		this.errorCode=errorCode;
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
