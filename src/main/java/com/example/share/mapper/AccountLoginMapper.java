package com.example.share.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.share.dto.AccountLoginDTO;
import com.example.share.dto.AccountRequestDTO;
import com.example.share.entities.Account;

@Mapper(componentModel = "spring")
public interface AccountLoginMapper extends BaseMapper<Account,AccountLoginDTO>{

	AccountLoginMapper INSTANCE =Mappers.getMapper(AccountLoginMapper.class);

	
}
