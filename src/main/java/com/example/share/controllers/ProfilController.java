package com.example.share.controllers;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.share.dto.ProfilDTO;
import com.example.share.dto.ProfilLightDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(path = "/api/v1/shareon/profil", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Profil", value = "Profil Controller")
public class ProfilController {
	
	@GetMapping({"","/"})
	@ApiResponses({ @ApiResponse(code = 500, message = "Une erreur système s'est produite") })
	@ApiOperation(value = "", nickname = "get All Profils, retourne success = true", notes = "", tags = {})
	public ResponseEntity<List<ProfilDTO>> getAll(){
		return null;
	}
	
	@GetMapping("/{uuid}")
	@ApiResponses({ @ApiResponse(code = 500, message = "Une erreur système s'est produite") })
	@ApiOperation(value = "", nickname = "get Profil By Uuid, retourne success = true", notes = "", tags = {})
	public ResponseEntity<ProfilDTO> getByUuid(@PathVariable String uuid){
		return null;
	}
	
	@PostMapping({"","/"})
	@ApiResponses({ @ApiResponse(code = 500, message = "Une erreur système s'est produite") })
	@ApiOperation(value = "", nickname = "create Profil, retourne success = true", notes = "", tags = {})
	public ResponseEntity<ProfilDTO> create(@RequestBody ProfilLightDTO profilLightDTO){
		return null;
	}
	
	@PutMapping({"","/"})
	@ApiResponses({ @ApiResponse(code = 500, message = "Une erreur système s'est produite") })
	@ApiOperation(value = "", nickname = "update Profil, retourne success = true", notes = "", tags = {})
	public ResponseEntity<ProfilDTO> update(@RequestBody ProfilLightDTO profilLightDTO){
		return null;
	}
	
	@DeleteMapping("/{uuid}")
	@ApiResponses({ @ApiResponse(code = 500, message = "Une erreur système s'est produite") })
	@ApiOperation(value = "", nickname = "delete Profil By Uuid, retourne success = true", notes = "", tags = {})
	public ResponseEntity<ProfilDTO> delete(@PathVariable String uuid){
		return null;
	}
	
	

}



