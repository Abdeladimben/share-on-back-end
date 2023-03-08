package com.example.share.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.share.dto.AccountResponseDTO;
import com.example.share.entities.Account;

@Mapper(componentModel = "spring")
public interface AccountResponseMapper extends BaseMapper<Account, AccountResponseDTO>{

    AccountResponseMapper INSTANCE =Mappers.getMapper(AccountResponseMapper.class);
    
}
