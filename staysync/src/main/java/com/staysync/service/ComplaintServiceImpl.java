package com.staysync.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staysync.dtos.ComplaintDto;
import com.staysync.mapper.ComplaintMapper;
import com.staysync.models.Complaints;
import com.staysync.models.PgDetails;
import com.staysync.models.Tenant;
import com.staysync.repository.ComplaintRepository;
import com.staysync.repository.PgDetailsRepository;
import com.staysync.repository.TenantRepository;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintRepository complaintRepository;
    @Autowired
    private ComplaintMapper complaintMapper;
    @Autowired
    private TenantRepository tenantRepository;
    @Autowired
    private PgDetailsRepository pgDetailsRepository;

    @Override
public void fileComplaint(ComplaintDto dto) {
    Complaints complaint = complaintMapper.toEntity(dto);

    Tenant tenant = tenantRepository.findById(dto.getTenantId()).orElse(null);
    if (tenant == null) {
        throw new RuntimeException("Tenant not found with id: " + dto.getTenantId());
    }
    complaint.setTenant(tenant);

    // Set PG if needed
    // PgDetails pg = pgDetailsRepository.findById(dto.getPgId()).orElse(null);
    // complaint.setPgDetails(pg);

    complaint.setStatus(dto.getStatus() != null ? dto.getStatus() : com.staysync.models.Enums.ComplaintStatus.OPEN);

    complaintRepository.save(complaint);
}

    @Override
    public List<ComplaintDto> getComplaintsByTenant(Long tenantId) {
        return complaintRepository.findByTenant_Id(tenantId)
                .stream()
                .map(complaintMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ComplaintDto> getComplaintsByPg(Long pgId) {
        return complaintRepository.findByPgDetailsId(pgId)
                .stream()
                .map(complaintMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void resolveComplaint(Integer complaintId) {
        Complaints complaint = complaintRepository.findById(complaintId).orElse(null);
        if (complaint != null) {
            complaint.setStatus(com.staysync.models.Enums.ComplaintStatus.RESOLVED);
            complaintRepository.save(complaint);
        }
    }
}