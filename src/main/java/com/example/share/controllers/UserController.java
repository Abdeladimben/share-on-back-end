package com.example.share.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.share.dto.UserLoginDTO;
import com.example.share.dto.UserRequestDTO;

import com.example.share.dto.UserWithoutRoleDTO;
import com.example.share.exception.EmailAlreadyExistsException;
import com.example.share.exception.PasswordIsNotValidException;
import com.example.share.exception.TokenIsExpiredException;
import com.example.share.exception.TokenIsNotValidException;
import com.example.share.helpers.LoginResponse;
import com.example.share.services.IUserService;
import com.example.share.services.UserService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(path = "/api/v1/shareon/user", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "User", value = "User Controller")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody UserLoginDTO userLoginDTO){
		return new ResponseEntity<>(userService.login(userLoginDTO),HttpStatus.OK);
	}
	
	@PostMapping("/create-user")
	public ResponseEntity<UserRequestDTO> createuser(@RequestBody UserWithoutRoleDTO userWithoutRoleDTO) throws EmailAlreadyExistsException, PasswordIsNotValidException{
		return new ResponseEntity<>(userService.create(userWithoutRoleDTO),HttpStatus.CREATED);
	}
	
	@PostMapping("/info")
	public ResponseEntity<UserRequestDTO> getInfoUser(HttpServletRequest request) throws EmailAlreadyExistsException, TokenIsExpiredException, TokenIsNotValidException{
		String accessToken = request.getHeader("Authorization");
		return new ResponseEntity<>(userService.info(accessToken),HttpStatus.OK);
	}
	
	
	

}
