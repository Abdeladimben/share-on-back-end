package com.example.share.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.share.dto.ProfilForPostDTO;
import com.example.share.entities.Post;

@Mapper(componentModel = "spring")
public interface ProfilForPostMapper extends BaseMapper<Post, ProfilForPostDTO> {

	ProfilForPostMapper INSTANCE =Mappers.getMapper(ProfilForPostMapper.class);
	
}
