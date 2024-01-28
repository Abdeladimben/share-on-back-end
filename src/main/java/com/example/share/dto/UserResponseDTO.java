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
public class UserResponseDTO {

	private String email;
	
	private String userName;
	
	private String nom;
	
	private String prenom;
		
	private String telephone;
	
	private Set<Role> roles = new HashSet<>();
	
}
