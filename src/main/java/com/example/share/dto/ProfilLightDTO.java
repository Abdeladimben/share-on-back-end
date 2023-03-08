package com.example.share.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfilLightDTO {

	private String uuid;
	
	private String nomUtilisateur;
	
    private byte[] photoProfil;
	
	private String adresse;
	
	private String genre;
	
	private LocalDate dateNaissance; 
	
	
	
	
}
