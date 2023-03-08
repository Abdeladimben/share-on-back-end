package com.example.share.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.share.dto.PostDTO;
import com.example.share.dto.ProfilLightDTO;
import com.example.share.entities.Post;
import com.example.share.entities.Profil;

@Mapper(componentModel = "spring")
public interface ProfilLightMapper extends BaseMapper<Profil, ProfilLightDTO>{

	ProfilLightMapper INSTANCE =Mappers.getMapper(ProfilLightMapper.class);

}
