package com.example.share.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.share.dto.PostCreatedDTO;
import com.example.share.dto.PostDTO;
import com.example.share.entities.Post;

@Mapper(componentModel = "spring")
public interface PostMapper extends BaseMapper<Post, PostDTO>{
	
	PostMapper INSTANCE =Mappers.getMapper(PostMapper.class);

	
}
