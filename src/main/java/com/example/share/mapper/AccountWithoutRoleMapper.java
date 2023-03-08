package com.example.share.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.share.dto.AccountWithoutRoleDTO;
import com.example.share.entities.Account;

@Mapper(componentModel = "spring")
public interface AccountWithoutRoleMapper extends BaseMapper<Account,AccountWithoutRoleDTO>{

	AccountWithoutRoleMapper INSTANCE =Mappers.getMapper(AccountWithoutRoleMapper.class);

}
