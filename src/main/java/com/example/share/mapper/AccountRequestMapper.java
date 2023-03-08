package com.example.share.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.share.dto.AccountRequestDTO;
import com.example.share.entities.Account;


@Mapper(componentModel = "spring")
public interface AccountRequestMapper extends BaseMapper<Account,AccountRequestDTO>{
	
	AccountRequestMapper INSTANCE =Mappers.getMapper(AccountRequestMapper.class);

}
