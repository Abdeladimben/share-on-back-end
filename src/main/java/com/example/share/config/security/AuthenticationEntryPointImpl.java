package com.example.share.config.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.example.share.enums.ErrorCode;
import com.example.share.exception.ErrorDetail;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
	private ObjectMapper objectMapper=new ObjectMapper();
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		response.setContentType(MediaType.APPLICATION_JSON.toString());
		response.setStatus(HttpStatus.UNAUTHORIZED.value()); 
		System.out.println(request.getRequestURI());
		response.getOutputStream()
						.println(
								objectMapper.writeValueAsString(
												new ErrorDetail(ErrorCode.U005,HttpStatus.UNAUTHORIZED.name(),request.getRequestURL().toString())
											)
						);
		
	}

}
