package com.example.share.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserWithoutRoleDTO {
	
	private String email;
	
	private String userName;
	
	private String nom;
	
	private String prenom;
	
	private String password;
		
	private String telephone;
	
}	