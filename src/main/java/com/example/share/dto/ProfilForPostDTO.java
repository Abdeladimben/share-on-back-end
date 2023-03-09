package com.example.share.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfilForPostDTO {
	
	private String uuid;
	
	private String nomUtilisateur;
	
    private byte[] photoProfil;
    
}
