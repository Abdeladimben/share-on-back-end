package com.example.share.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.share.dto.AccountLoginDTO;
import com.example.share.dto.AccountRequestDTO;

import com.example.share.dto.AccountWithoutRoleDTO;
import com.example.share.exception.EmailAlreadyExistsException;
import com.example.share.helpers.LoginResponse;
import com.example.share.services.AccountServiceImpl;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(path = "/api/v1/shareon/account", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Account", value = "Account Controller")
public class AccountController {
	
	@Autowired
	AccountServiceImpl accountServiceImpl;
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@RequestBody AccountLoginDTO accountLoginDTO){
		return new ResponseEntity<>(accountServiceImpl.login(accountLoginDTO),HttpStatus.OK);
	}
	
	@PostMapping("/create-account")
	public ResponseEntity<AccountRequestDTO> createAccount(@RequestBody AccountWithoutRoleDTO accountWithoutRoleDTO) throws EmailAlreadyExistsException{
		return new ResponseEntity<>(accountServiceImpl.create(accountWithoutRoleDTO),HttpStatus.CREATED);
	}
	
	
	

}
