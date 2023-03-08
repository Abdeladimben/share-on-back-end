package com.example.share.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.share.dto.ProfilDTO;
import com.example.share.dto.ProfilLightDTO;
import com.example.share.entities.Profil;

@Mapper(componentModel = "spring")
public interface ProfilMapper extends BaseMapper<Profil, ProfilDTO>{
	
	ProfilMapper INSTANCE =Mappers.getMapper(ProfilMapper.class);

	
}
