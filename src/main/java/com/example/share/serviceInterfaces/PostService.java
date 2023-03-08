package com.example.share.serviceInterfaces;

import java.util.List;

import com.example.share.dto.PostDTO;

public interface PostService {

	public List<PostDTO> findAll();
	
	public List<PostDTO> findByNomUtilisateur(String nomUtilisateur);
	
	public PostDTO findByUuid(String uuid);
	
	public PostDTO create(PostDTO postDTO);
	
	public PostDTO update(PostDTO postDTO);
	
	public PostDTO deleteByUuid(String uuid);
	
}
