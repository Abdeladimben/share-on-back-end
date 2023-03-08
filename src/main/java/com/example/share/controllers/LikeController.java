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

import com.example.share.dto.LikesDTO;
import com.example.share.dto.PostCreatedDTO;
import com.example.share.dto.PostDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping(path = "/api/v1/shareon/like", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Like", value = "Like Controller")
public class LikeController {

	
	@GetMapping({"","/"})
	@ApiResponses({ @ApiResponse(code = 500, message = "Une erreur système s'est produite") })
	@ApiOperation(value = "", nickname = "get All Likes, retourne success = true", notes = "", tags = {})
	public ResponseEntity<List<LikesDTO>> getAll(){
		return null;
	}
	
	@GetMapping("/{uuid}")
	@ApiResponses({ @ApiResponse(code = 500, message = "Une erreur système s'est produite") })
	@ApiOperation(value = "", nickname = "get Like By Uuid, retourne success = true", notes = "", tags = {})
	public ResponseEntity<LikesDTO> getByUuid(@PathVariable String uuid){
		return null;
	}
	
	@PostMapping({"","/"})
	@ApiResponses({ @ApiResponse(code = 500, message = "Une erreur système s'est produite") })
	@ApiOperation(value = "", nickname = "create Like, retourne success = true", notes = "", tags = {})
	public ResponseEntity<LikesDTO> create(@RequestBody LikesDTO likesDTO){
		return null;
	}
	
	@DeleteMapping("/{uuid}")
	@ApiResponses({ @ApiResponse(code = 500, message = "Une erreur système s'est produite") })
	@ApiOperation(value = "", nickname = "delete Like By Uuid, retourne success = true", notes = "", tags = {})
	public ResponseEntity<LikesDTO> delete(@PathVariable String uuid){
		return null;
	}
	
}
