package com.example.share.serviceInterfaces;

import com.example.share.dto.ProfilLightDTO;
import com.example.share.entities.Profil;

public interface ProfilService {
	
	Profil create(ProfilLightDTO profilLightDTO);

	Profil update(ProfilLightDTO profilLightDTO);
	
	Profil delete(String uuid);
	
	Profil findByUuid(String uuid);
	
	Profil findByNomUtilisateur(String nomUtilisateur);
	
}
