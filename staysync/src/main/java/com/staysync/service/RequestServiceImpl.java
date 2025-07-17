package com.staysync.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staysync.dtos.TenantRequestDto;
import com.staysync.mapper.TenantRequestMapper;
import com.staysync.models.PgDetails;
import com.staysync.models.Tenant;
import com.staysync.models.TenantRequests;
import com.staysync.models.Users;
import com.staysync.models.Enums.RequestStatus;
import com.staysync.models.Enums.TenantStatus;
import com.staysync.repository.PgDetailsRepository;
import com.staysync.repository.TenantRepository;
import com.staysync.repository.TenantRequestRepository;
import com.staysync.repository.UserRepository;
@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    private TenantRequestRepository tenantRequestRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PgDetailsRepository pgDetailsRepository;

    @Autowired
    private TenantRepository tenantRepository;

    @Autowired
    private TenantRequestMapper tenantRequestMapper;

    @Override
    public void createJoinRequest(TenantRequestDto req) {

        Users tenant = userRepository.findById(req.getPotentialTenantId())
                .orElseThrow(() -> new RuntimeException("Tenant not found"));

        PgDetails pgDetails = pgDetailsRepository.findById(req.getPgId())
                .orElseThrow(() -> new RuntimeException("PG not found"));
        TenantRequests tenantRequest = TenantRequests.builder().potentialTenant(tenant)
                .pgDetails(pgDetails).requestDate(LocalDate.now()).status(RequestStatus.PENDING).build();

        tenantRequestRepository.save(tenantRequest);
    }

    @Override
    public List<TenantRequestDto> getMyRequests() {
        return null; // Placeholder return statement
    }

    @Override
    public List<TenantRequestDto> getPGRequests(Long pgId) {
        List<TenantRequests> requests = tenantRequestRepository.findByPgDetailsId(pgId);

           return requests.stream()
            .map(tenantRequestMapper::toDto)
            .toList();
    }

    /* 
    @Override
    public void approveRequest(Long requestId) {
        // Implementation logic for approving a request\
            TenantRequests request = tenantRequestRepository.findById(requestId)
            .orElseThrow(() -> new RuntimeException("Request not found"));
    request.setStatus(RequestStatus.APPROVED);
    tenantRequestRepository.save(request);
        
    }
    */
    

@Override
public void approveRequest(Long requestId) {
    TenantRequests request = tenantRequestRepository.findById(requestId)
        .orElseThrow(() -> new RuntimeException("Request not found"));
    request.setStatus(RequestStatus.APPROVED);
    tenantRequestRepository.save(request);

    boolean exists = tenantRepository.existsByUser_IdAndPgDetails_Id(
    request.getPotentialTenant().getId(), request.getPgDetails().getId());
    if (!exists) {
        Tenant tenant = new Tenant();
        tenant.setUser(request.getPotentialTenant());
        tenant.setPgDetails(request.getPgDetails());
        tenant.setStatus(TenantStatus.ACTIVE.name()); // Use .name() for String
        tenant.setCheckInDate(LocalDate.now());
        tenant.setActive(true); // Set active true if needed
        tenantRepository.save(tenant);
    }
}
    @Override
    public void rejectRequest(Long requestId) {
        // Implementation logic for rejecting a request
        TenantRequests request = tenantRequestRepository.findById(requestId)
            .orElseThrow(() -> new RuntimeException("Request not found"));
    request.setStatus(RequestStatus.REJECTED);
    tenantRequestRepository.save(request);
}

}
