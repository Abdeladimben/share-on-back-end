package com.example.share.mapper;

import java.util.List;

import org.mapstruct.MappingTarget;

public interface BaseMapper<E,D> {
	
	D EntityToDto(E entity);
	
	E DtotoEntity(D Dto);
	
	List<D> listOfEntityToListOfDto(List<E> listEntity);
	
	E updateEntityFromDto(D Dto, @MappingTarget E entity);
}
