package com.example.share.dto;

import java.util.Set;

import com.example.share.entities.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePasswordDTO {

	private String email;
	
	private String password;
	
	private String nouveauPassword;
	
	private String confirmPassword;
}
