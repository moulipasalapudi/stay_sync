package com.staysync.service;

import java.util.List;
import com.staysync.dtos.ComplaintDto;

public interface ComplaintService {
    void fileComplaint(ComplaintDto complaintDto);
    List<ComplaintDto> getComplaintsByTenant(Long tenantId);
    List<ComplaintDto> getComplaintsByPg(Long pgId);
    void resolveComplaint(Integer complaintId);
}