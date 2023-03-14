package com.example.share.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.share.config.security.JwtUtil;
import com.example.share.dto.PageResponse;
import com.example.share.dto.ProfilLightDTO;
import com.example.share.entities.Profil;
import com.example.share.enums.ErrorCode;
import com.example.share.exception.GeneralException;
import com.example.share.exception.NoContentException;
import com.example.share.mapper.ProfilLightMapper;
import com.example.share.repositories.ProfilRepository;
import com.example.share.serviceInterfaces.ProfilService;

@Service
public class ProfilServiceImpl implements ProfilService{
	
	@Autowired
	ProfilRepository profilRepository;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@Autowired
	ProfilLightMapper profilLightMapper;
	
	@Override
	public PageResponse<ProfilLightDTO> findAll(int pageNumber,int elementsNumber) throws NoContentException {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNumber, elementsNumber);
		Page<Profil> profils = profilRepository.findAll(pageable);
		if(!profils.isEmpty()) {
			List<ProfilLightDTO> profilLightDTOs = profilLightMapper.listOfEntityToListOfDto(profils.getContent());
			PageResponse<ProfilLightDTO> pageResponse=
										PageResponse.<ProfilLightDTO>builder()
														.currentPage(profils.getNumber())
														.totalElements(profils.getTotalElements())
														.totalPages(profils.getTotalPages())
														.content(profilLightDTOs)
														.build();
			return pageResponse;
		}else
			throw new NoContentException(ErrorCode.PR003.getMessage(),ErrorCode.PR003, HttpStatus.NO_CONTENT);
		
	}

	@Override
	public ProfilLightDTO findByUuid(String uuid) throws NoContentException {
		// TODO Auto-generated method stub
		Profil profil= profilRepository.findByUuid(uuid)
				.orElseThrow(() -> new NoContentException(ErrorCode.PR002.getMessage(),ErrorCode.PR002, HttpStatus.NO_CONTENT));
		ProfilLightDTO profilLightDTO=profilLightMapper.EntityToDto(profil);
		return profilLightDTO;
	}

	@Override
	public ProfilLightDTO findByNomUtilisateur(String nomUtilisateur) throws NoContentException {
		// TODO Auto-generated method stub
		Profil profil= profilRepository.findByNomUtilisateur(nomUtilisateur)
				.orElseThrow(() -> new NoContentException(ErrorCode.PR002.getMessage(),ErrorCode.PR002, HttpStatus.NO_CONTENT));
		ProfilLightDTO profilLightDTO=profilLightMapper.EntityToDto(profil);
		return profilLightDTO;
	}
	

	@Override
	public ProfilLightDTO findByUserConnecte(String token) throws NoContentException {
		// TODO Auto-generated method stub
		String userEmail = jwtUtil.extractUserEmail(token);
		Profil profil= profilRepository.findByUtilisateur_Email(userEmail)
				.orElseThrow(() -> new NoContentException(ErrorCode.PR002.getMessage(),ErrorCode.PR002, HttpStatus.NO_CONTENT));
		ProfilLightDTO profilLightDTO=profilLightMapper.EntityToDto(profil);
		return profilLightDTO;
	}

	@Override
	public ProfilLightDTO create(ProfilLightDTO profilLightDTO) throws GeneralException {
		// TODO Auto-generated method stub
		Optional<Profil> profil= profilRepository.findByNomUtilisateur(profilLightDTO.getNomUtilisateur());
		if(profil.isPresent())
			throw new GeneralException(ErrorCode.PR003.getMessage(), ErrorCode.PR003, HttpStatus.CONFLICT);
		else {
			Profil savedProfil= profilLightMapper.DtotoEntity(profilLightDTO);
			profilRepository.save(savedProfil);
			ProfilLightDTO returnProfilLightDTO=profilLightMapper.EntityToDto(savedProfil);
			return returnProfilLightDTO;
		}
		
	}

	@Override
	public ProfilLightDTO update(ProfilLightDTO profilLightDTO) throws GeneralException {
		// TODO Auto-generated method stub
		Optional<Profil> profil= profilRepository.findByNomUtilisateur(profilLightDTO.getNomUtilisateur());
		if(!profil.isPresent())
			throw new GeneralException(ErrorCode.PR002.getMessage(), ErrorCode.PR002, HttpStatus.NO_CONTENT);
		else {
			Profil updatedProfil= profilLightMapper.updateEntityFromDto(profilLightDTO, profil.get());
			profilRepository.save(updatedProfil);
			ProfilLightDTO returnProfilLightDTO=profilLightMapper.EntityToDto(updatedProfil);
			return returnProfilLightDTO;
		}
	}

	@Override
	public ProfilLightDTO delete(String uuid) throws NoContentException {
		// TODO Auto-generated method stub
		Profil profil= profilRepository.findByUuid(uuid)
				.orElseThrow(() -> new NoContentException(ErrorCode.PR002.getMessage(),ErrorCode.PR002, HttpStatus.NO_CONTENT));
		profil.setDelete(true);
		profil.setStatut(false);
		Profil deletedProfil = profilRepository.save(profil);
		ProfilLightDTO returnProfilLightDTO = profilLightMapper.EntityToDto(deletedProfil);
		return returnProfilLightDTO;
	}

	@Override
	public ProfilLightDTO signale(String uuid) throws NoContentException {
		// TODO Auto-generated method stub
		Profil profil= profilRepository.findByUuid(uuid)
				.orElseThrow(() -> new NoContentException(ErrorCode.PR002.getMessage(),ErrorCode.PR002, HttpStatus.NO_CONTENT));
		return null;
	}

	@Override
	public ProfilLightDTO activation(String uuid) throws NoContentException {
		// TODO Auto-generated method stub
		Profil profil= profilRepository.findByUuid(uuid)
				.orElseThrow(() -> new NoContentException(ErrorCode.PR002.getMessage(),ErrorCode.PR002, HttpStatus.NO_CONTENT));
		return null;
	}


}
