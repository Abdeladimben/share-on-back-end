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
		if(authException.toString().contains("UsernameNotFoundException")) {
			response.setStatus(HttpStatus.BAD_REQUEST.value()); 
			response.getOutputStream()
				.println(
					objectMapper.writeValueAsString(
						new ErrorDetail(ErrorCode.U001,request.getRequestURL().toString())
					)
				);
		}else {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			response.getOutputStream()
				.println(
					objectMapper.writeValueAsString(
						new ErrorDetail(ErrorCode.U005,request.getRequestURL().toString())
					)
				);
		}		
		
	}

}
