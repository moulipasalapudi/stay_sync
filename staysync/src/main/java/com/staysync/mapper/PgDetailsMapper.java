package com.staysync.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.staysync.dtos.PgDetailsDto;
import com.staysync.models.PgDetails;

@Mapper(componentModel = "spring")
public interface PgDetailsMapper {

    PgDetailsDto toDto(PgDetails pgDetails);
    PgDetails toEntity(PgDetailsDto dto);
    List<PgDetailsDto> toDtoList(List<PgDetails> pgDetailsList);
    
}
