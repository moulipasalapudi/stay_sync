package com.staysync.mapper;


import org.mapstruct.Mapper;

import com.staysync.dtos.TenantDto;
import com.staysync.models.Tenant;


@Mapper(componentModel = "spring")
public interface TenantMapper {
    TenantDto toDto(Tenant tenant);
     Tenant toEntity(TenantDto dto);
}
