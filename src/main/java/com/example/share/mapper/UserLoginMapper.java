package com.example.share.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.share.dto.UserLoginDTO;
import com.example.share.dto.UserRequestDTO;
import com.example.share.entities.User;

@Mapper(componentModel = "spring")
public interface UserLoginMapper extends BaseMapper<User,UserLoginDTO>{

	UserLoginMapper INSTANCE =Mappers.getMapper(UserLoginMapper.class);

	
}
