package com.example.share.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.share.dto.UserResponseDTO;
import com.example.share.entities.User;

@Mapper(componentModel = "spring")
public interface UserResponseMapper extends BaseMapper<User, UserResponseDTO>{

    UserResponseMapper INSTANCE =Mappers.getMapper(UserResponseMapper.class);
    
}
