package com.example.share.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.share.dto.PageResponse;
import com.example.share.dto.ProfilDTO;
import com.example.share.dto.ProfilLightDTO;
import com.example.share.exception.GeneralException;
import com.example.share.exception.NoContentException;
import com.example.share.serviceInterfaces.ProfilService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(path = "/api/v1/shareon/profil", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Profil", value = "Profil Controller")
public class ProfilController {
	
	@Autowired
	ProfilService profilServiceImpl;
	
	@GetMapping({"","/"})
	@ApiResponses({ @ApiResponse(code = 500, message = "Une erreur système s'est produite") })
	@ApiOperation(value = "", nickname = "get All Profils, retourne success = true", notes = "", tags = {})
	public ResponseEntity<PageResponse<ProfilLightDTO>> getAll(@RequestParam(defaultValue = "0") int pageNumber,
			@RequestParam(defaultValue = "2") int elementsNumber) throws NoContentException{
		return ResponseEntity.ok().body(profilServiceImpl.findAll(pageNumber, elementsNumber));
	}
	
	@GetMapping("/{uuid}")
	@ApiResponses({ @ApiResponse(code = 500, message = "Une erreur système s'est produite") })
	@ApiOperation(value = "", nickname = "get Profil By Uuid, retourne success = true", notes = "", tags = {})
	public ResponseEntity<ProfilLightDTO> getByUuid(@PathVariable String uuid) throws NoContentException{
		return ResponseEntity.ok().body(profilServiceImpl.findByUuid(uuid));
	}
	
	@GetMapping("/nom-utilisateur/{nom}")
	@ApiResponses({ @ApiResponse(code = 500, message = "Une erreur système s'est produite") })
	@ApiOperation(value = "", nickname = "get Profil By Nom Utilisateur, retourne success = true", notes = "", tags = {})
	public ResponseEntity<ProfilLightDTO> getByNomUtilisateur(@PathVariable String nom) throws NoContentException{
		return ResponseEntity.ok().body(profilServiceImpl.findByNomUtilisateur(nom));
	}
	
	@PostMapping({"","/"})
	@ApiResponses({ @ApiResponse(code = 500, message = "Une erreur système s'est produite") })
	@ApiOperation(value = "", nickname = "create Profil, retourne success = true", notes = "", tags = {})
	public ResponseEntity<ProfilLightDTO> create(@RequestBody ProfilLightDTO profilLightDTO) throws NoContentException, GeneralException{
		return ResponseEntity.ok().body(profilServiceImpl.create(profilLightDTO));
	}
	
	@PutMapping({"","/"})
	@ApiResponses({ @ApiResponse(code = 500, message = "Une erreur système s'est produite") })
	@ApiOperation(value = "", nickname = "update Profil, retourne success = true", notes = "", tags = {})
	public ResponseEntity<ProfilLightDTO> update(@RequestBody ProfilLightDTO profilLightDTO) throws NoContentException, GeneralException{
		return ResponseEntity.ok().body(profilServiceImpl.update(profilLightDTO));
	}
	
	@DeleteMapping("/{uuid}")
	@ApiResponses({ @ApiResponse(code = 500, message = "Une erreur système s'est produite") })
	@ApiOperation(value = "", nickname = "delete Profil By Uuid, retourne success = true", notes = "", tags = {})
	public ResponseEntity<ProfilLightDTO> delete(@PathVariable String uuid) throws NoContentException{
		return ResponseEntity.ok().body(profilServiceImpl.delete(uuid));
	}
	
	

}



