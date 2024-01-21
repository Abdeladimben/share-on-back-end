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
import com.example.share.dto.PostCreatedDTO;
import com.example.share.dto.PostDTO;
import com.example.share.exception.GeneralException;
import com.example.share.exception.NoContentException;
import com.example.share.services.IPostService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(path = "/api/v1/shareon/post", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Post", value = "Post Controller")
public class PostController {
	
	@Autowired
	IPostService postServiceImpl;

	@GetMapping({"","/"})
	@ApiResponses({ @ApiResponse(code = 500, message = "Une erreur système s'est produite") })
	@ApiOperation(value = "", nickname = "get All Posts, retourne success = true", notes = "", tags = {})
	public ResponseEntity<PageResponse<PostDTO>> getAll(@RequestParam(defaultValue = "0") int pageNumber,
			@RequestParam(defaultValue = "2") int elementsNumber) throws NoContentException{
		return ResponseEntity.ok().body(postServiceImpl.findAll(pageNumber, elementsNumber));
	}
	
	@GetMapping("/{uuid}")
	@ApiResponses({ @ApiResponse(code = 500, message = "Une erreur système s'est produite") })
	@ApiOperation(value = "", nickname = "get Post By Uuid, retourne success = true", notes = "", tags = {})
	public ResponseEntity<PostDTO> getByUuid(@PathVariable String uuid) throws NoContentException{
		return ResponseEntity.ok().body(postServiceImpl.findByUuid(uuid));
	}
	
	@PostMapping({"","/"})
	@ApiResponses({ @ApiResponse(code = 500, message = "Une erreur système s'est produite") })
	@ApiOperation(value = "", nickname = "create Post, retourne success = true", notes = "", tags = {})
	public ResponseEntity<PostDTO> create(@RequestBody PostCreatedDTO postCreatedDTO){
		return ResponseEntity.ok().body(postServiceImpl.create(postCreatedDTO));
	}
	
	@PutMapping({"","/"})
	@ApiResponses({ @ApiResponse(code = 500, message = "Une erreur système s'est produite") })
	@ApiOperation(value = "", nickname = "update Post, retourne success = true", notes = "", tags = {})
	public ResponseEntity<PostDTO> update(@RequestBody PostDTO postDTO) throws GeneralException{
		return ResponseEntity.ok().body(postServiceImpl.update(postDTO));
	}
	
	@DeleteMapping("/{uuid}")
	@ApiResponses({ @ApiResponse(code = 500, message = "Une erreur système s'est produite") })
	@ApiOperation(value = "", nickname = "delete Post By Uuid, retourne success = true", notes = "", tags = {})
	public ResponseEntity<PostDTO> delete(@PathVariable String uuid) throws NoContentException{
		return ResponseEntity.ok().body(postServiceImpl.delete(uuid));
	}
	
}


