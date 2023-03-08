package com.example.share.dto;

import java.time.LocalDate;

import com.example.share.enums.Roles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {

	private String uuid;

	private String libelle;
	
	private Roles nom;
	
}
