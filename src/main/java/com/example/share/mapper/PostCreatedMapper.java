package com.example.share.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.share.dto.PostCreatedDTO;
import com.example.share.entities.Post;

@Mapper(componentModel = "spring")
public interface PostCreatedMapper extends BaseMapper<Post, PostCreatedDTO>{
	
	PostCreatedMapper INSTANCE =Mappers.getMapper(PostCreatedMapper.class);

	
}
