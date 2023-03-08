package com.example.share.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfilDTO {

	private String uuid;
	
	private String nomUtilisateur;
	
    private byte[] photoProfil;
	
	private String adresse;
	
	private String genre;
	
	private LocalDate dateNaissance; 
	
	private List<PostDTO> posts;
	
	
}
