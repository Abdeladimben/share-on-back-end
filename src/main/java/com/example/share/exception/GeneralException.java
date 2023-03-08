package com.example.share.exception;

import org.springframework.http.HttpStatus;

import com.example.share.enums.ErrorCode;

public class GeneralException extends ApiBaseException{

	public GeneralException(String message,ErrorCode errorCode,HttpStatus httpStatus) {
		super(message, errorCode, httpStatus);
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
