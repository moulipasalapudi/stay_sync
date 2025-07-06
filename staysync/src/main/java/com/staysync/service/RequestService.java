package com.staysync.service;

import java.util.List;

import com.staysync.dtos.TenantRequestDto;

public interface RequestService {
    void createJoinRequest(TenantRequestDto req);
List<TenantRequestDto> getMyRequests();
List<TenantRequestDto> getPGRequests(Long pgId);
void approveRequest(Long requestId);
void rejectRequest(Long requestId);
}
