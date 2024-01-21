package com.example.share.exception;

import java.util.Date;

import com.example.share.enums.ErrorCode;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

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

	public ErrorDetail(ErrorCode code, String uri) {
		this();
		this.code=code;
		this.message = code.getMessage();
		this.uri = uri;
	}
	
	public ErrorDetail(ErrorCode code) {
		this();
		this.code=code;
		this.message = code.getMessage();
	}
	
    public String convertToJson() throws JsonProcessingException {
        if (this == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        return mapper.writeValueAsString(this);
    }
}
