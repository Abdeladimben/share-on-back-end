package com.example.share.serviceInterfaces;

import java.util.List;

import com.example.share.dto.PageResponse;
import com.example.share.dto.ProfilLightDTO;
import com.example.share.exception.GeneralException;
import com.example.share.exception.NoContentException;

public interface ProfilService {
	
	PageResponse<ProfilLightDTO> findAll(int pageNumber,int elementsNumber) throws NoContentException;
	
	ProfilLightDTO findByUuid(String uuid) throws NoContentException;
	
	ProfilLightDTO findByNomUtilisateur(String nomUtilisateur) throws NoContentException;
	
	ProfilLightDTO findByUserConnecte(String token) throws NoContentException;
	
	ProfilLightDTO create(ProfilLightDTO profilLightDTO) throws NoContentException, GeneralException;

	ProfilLightDTO update(ProfilLightDTO profilLightDTO) throws NoContentException, GeneralException;
	
	ProfilLightDTO delete(String uuid) throws NoContentException;
	
	ProfilLightDTO signale(String uuid) throws NoContentException;
	
	ProfilLightDTO activation(String uuid) throws NoContentException;
	

	
}
