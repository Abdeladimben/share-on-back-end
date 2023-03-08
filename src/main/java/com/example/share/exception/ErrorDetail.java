package com.example.share.exception;

import java.util.Date;

import com.example.share.enums.ErrorCode;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorDetail {
	
	@JsonFormat
	private ErrorCode code;
	
	@JsonFormat
	private String message;
	
	@JsonFormat
	private String uri;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd/MM/yyyy  hh:mm:dd")
	private Date timeStamp;
	
	public ErrorDetail() {
		this.timeStamp=new Date();
	}

	public ErrorDetail(String message, String uri) {
		this();
		this.message = message;
		this.uri = uri;
	}
	
	public ErrorDetail(ErrorCode code,String message, String uri) {
		this();
		this.code=code;
		this.message = message;
		this.uri = uri;
	}
}
