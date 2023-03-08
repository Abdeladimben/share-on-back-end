package com.example.share.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.share.dto.PostDTO;
import com.example.share.entities.Post;
import com.example.share.mapper.PostMapper;
import com.example.share.repositories.PostRepository;
import com.example.share.serviceInterfaces.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	PostMapper postMapper; 
	

	@Override
	public List<PostDTO> findAll() {
		// TODO Auto-generated method stub
		List<Post> posts=postRepository.findAll();
		if(!posts.isEmpty()) {
			List<PostDTO> postDTOs= postMapper.listOfEntityToListOfDto(posts);
			return postDTOs;
		}
		return null;
	}

	@Override
	public List<PostDTO> findByNomUtilisateur(String nomUtilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDTO findByUuid(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDTO create(PostDTO postDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDTO update(PostDTO postDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDTO deleteByUuid(String uuid) {
		// TODO Auto-generated method stub
		return null;
	}

}
