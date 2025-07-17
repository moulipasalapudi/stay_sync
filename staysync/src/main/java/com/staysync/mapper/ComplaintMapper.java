package com.staysync.mapper;

import org.mapstruct.*;
import com.staysync.dtos.ComplaintDto;
import com.staysync.models.Complaints;

@Mapper(componentModel = "spring")
public interface ComplaintMapper {
    @Mapping(source = "tenant.id", target = "tenantId")
    @Mapping(source = "pgDetails.id", target = "pgId")
    ComplaintDto toDto(Complaints entity);

    @Mapping(target = "tenant", ignore = true)
    @Mapping(target = "pgDetails", ignore = true)
    Complaints toEntity(ComplaintDto dto);
}