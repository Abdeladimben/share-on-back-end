package com.example.share.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.share.dto.PageResponse;
import com.example.share.dto.PostCreatedDTO;
import com.example.share.dto.PostDTO;
import com.example.share.entities.Post;
import com.example.share.enums.ErrorCode;
import com.example.share.exception.GeneralException;
import com.example.share.exception.NoContentException;
import com.example.share.mapper.PostCreatedMapper;
import com.example.share.mapper.PostMapper;
import com.example.share.repositories.PostRepository;

@Service
public class PostService implements IPostService {
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	PostMapper postMapper; 
	
	@Autowired
	PostCreatedMapper postCreatedMapper; 
	

	@Override
	public PageResponse<PostDTO> findAll(int pageNumber,int elementsNumber) throws NoContentException {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNumber,elementsNumber);
		Page<Post> posts=postRepository.findAll(pageable);
		if(!posts.isEmpty()) {
			List<PostDTO> postDTOs= postMapper.listOfEntityToListOfDto(posts.getContent());
			PageResponse<PostDTO> pageResponse = PageResponse.<PostDTO>builder()
																	.content(postDTOs)
																	.currentPage(posts.getNumber())
																	.totalElements(posts.getTotalElements())
																	.totalPages(posts.getTotalPages())
																	.build();
			return pageResponse;
		}else
			throw new NoContentException(ErrorCode.P003.getMessage(), ErrorCode.P003, HttpStatus.NO_CONTENT);
	}
	
	 

	@Override
	public PostDTO findByNomUtilisateur(String nomUtilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDTO findByUuid(String uuid) throws NoContentException {
		// TODO Auto-generated method stub
		Post post= postRepository.findByUuid(uuid)
				.orElseThrow(() -> new NoContentException(ErrorCode.P003.getMessage(),ErrorCode.P003, HttpStatus.NO_CONTENT));
		PostDTO postDTO=postMapper.EntityToDto(post);
		return postDTO;
	}

	@Override
	public PostDTO create(PostCreatedDTO postDTO) {
		// TODO Auto-generated method stub
		Post savedProfil= postCreatedMapper.DtotoEntity(postDTO);
		postRepository.save(savedProfil);
		PostDTO returnPostDTO=postMapper.EntityToDto(savedProfil);
		return returnPostDTO;
	}

	@Override
	public PostDTO update(PostDTO postDTO) throws GeneralException {
		// TODO Auto-generated method stub
		Optional<Post> post= postRepository.findByUuid(postDTO.getUuid());
		if(!post.isPresent())
			throw new GeneralException(ErrorCode.PR002.getMessage(), ErrorCode.PR002, HttpStatus.NO_CONTENT);
		else {
			Post updatedPost= postMapper.updateEntityFromDto(postDTO, post.get());
			postRepository.save(updatedPost);
			PostDTO returnPostDTO=postMapper.EntityToDto(updatedPost);
			return returnPostDTO;
		}
	}

	@Override
	public PostDTO delete(String uuid) throws NoContentException {
		// TODO Auto-generated method stub
		Post post= postRepository.findByUuid(uuid)
				.orElseThrow(() -> new NoContentException(ErrorCode.PR002.getMessage(),ErrorCode.PR002, HttpStatus.NO_CONTENT));
		post.setDelete(true);
		post.setStatut(false);
		Post deletedPost = postRepository.save(post);
		PostDTO returnPostDTO = postMapper.EntityToDto(deletedPost);
		return returnPostDTO;
	}

	@Override
	public PostDTO signale(String uuid) throws NoContentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDTO activation(String uuid) throws NoContentException {
		// TODO Auto-generated method stub
		return null;
	}

}
