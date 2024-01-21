package com.example.share.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.share.dto.UserWithoutRoleDTO;
import com.example.share.entities.User;

@Mapper(componentModel = "spring")
public interface UserWithoutRoleMapper extends BaseMapper<User,UserWithoutRoleDTO>{

	UserWithoutRoleMapper INSTANCE =Mappers.getMapper(UserWithoutRoleMapper.class);

}
