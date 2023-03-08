package com.example.share.helpers;

import com.example.share.dto.AccountResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse {
	
	private String accessToken;
	
	private AccountResponseDTO accountResponseDTO;

}
