package com.example.share.exception;

import org.springframework.http.HttpStatus;

import com.example.share.enums.ErrorCode;

public abstract class ApiBaseException extends Exception{
	
	ErrorCode errorCode;
	HttpStatus httpStatus;
	
	public ApiBaseException(String message,ErrorCode errorCode,HttpStatus httpStatus){
        super(message);
        this.errorCode=errorCode;
    }
	
	public ApiBaseException(String message,ErrorCode errorCode){
        super(message);
        this.errorCode=errorCode;
    }
	
	public ApiBaseException(ErrorCode errorCode){
        super(errorCode.getMessage());
        this.errorCode=errorCode;
    }
	
	public abstract ErrorCode getCode();
	
	public abstract HttpStatus getStatus();
	
	

}
