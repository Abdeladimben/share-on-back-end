package com.example.share.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.share.dto.AccountResponseDTO;
import com.example.share.dto.LikesDTO;
import com.example.share.entities.Account;
import com.example.share.entities.Likes;


@Mapper(componentModel = "spring")
public interface LikesMapper extends BaseMapper<Likes, LikesDTO>{

	LikesMapper INSTANCE =Mappers.getMapper(LikesMapper.class);
	
	
}
