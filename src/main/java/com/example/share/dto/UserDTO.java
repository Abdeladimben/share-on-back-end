package com.example.share.dto;

import java.util.HashSet;
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
public class UserDTO {

	private String uuid;
	
	private String email;
	
	private String nom;
	
	private String prenom;
	
	private String password;
		
	private String telephone;
	
	private Set<Role> roles = new HashSet<>();
	
}
