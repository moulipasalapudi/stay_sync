package com.staysync.mapper;

import org.mapstruct.Mapper;

import com.staysync.dtos.TenantRequestDto;
import com.staysync.models.TenantRequests;

@Mapper(componentModel = "spring")
public interface TenantRequestMapper {


    TenantRequestDto toDto(TenantRequests tenantRequest);
    TenantRequests toEntity(TenantRequestDto dto);
    
}
