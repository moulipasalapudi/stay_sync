package com.staysync.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ValueMapping;
import org.mapstruct.ValueMappings;

import com.staysync.dtos.TenantRequestDto;
import com.staysync.models.TenantRequests;
import com.staysync.models.Enums.RequestStatus;
import com.staysync.models.Enums.TenantStatus;

@Mapper(componentModel = "spring")
public interface TenantRequestMapper {

    @ValueMappings({
        @ValueMapping(source = "PENDING", target = "ACTIVE"),
        @ValueMapping(source = "APPROVED", target = "ACTIVE"),
        @ValueMapping(source = "REJECTED", target = "CHECKED_OUT")
    })
    TenantStatus requestStatusToTenantStatus(RequestStatus status);

    @ValueMappings({
        @ValueMapping(source = "ACTIVE", target = "APPROVED"),
        @ValueMapping(source = "CHECKOUT_REQUESTED", target = "PENDING"),
        @ValueMapping(source = "CHECKED_OUT", target = "REJECTED")
    })
    RequestStatus tenantStatusToRequestStatus(TenantStatus status);

    TenantRequestDto toDto(TenantRequests tenantRequest);
    TenantRequests toEntity(TenantRequestDto dto);

}
