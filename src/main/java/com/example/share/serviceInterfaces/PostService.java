package com.example.share.serviceInterfaces;

import java.util.List;

import com.example.share.dto.PageResponse;
import com.example.share.dto.PostCreatedDTO;
import com.example.share.dto.PostDTO;
import com.example.share.dto.ProfilLightDTO;
import com.example.share.exception.GeneralException;
import com.example.share.exception.NoContentException;

public interface PostService {

	public PageResponse<PostDTO> findAll(int pageNumber,int elementsNumber) throws NoContentException;
	
	public PostDTO findByNomUtilisateur(String nomUtilisateur);
	
	public PostDTO findByUuid(String uuid) throws NoContentException;
	
	public PostDTO create(PostCreatedDTO postDTO);
	
	public PostDTO update(PostDTO postDTO) throws GeneralException;
	
	public PostDTO delete(String uuid) throws NoContentException;
	
	public PostDTO signale(String uuid) throws NoContentException;
	
	public PostDTO activation(String uuid) throws NoContentException;
	
}
