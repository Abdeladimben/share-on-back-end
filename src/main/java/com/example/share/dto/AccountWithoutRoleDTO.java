package com.example.share.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountWithoutRoleDTO {
	
	private String email;
	
	private String nom;
	
	private String prenom;
	
	private String password;
		
	private String telephone;
	
}	