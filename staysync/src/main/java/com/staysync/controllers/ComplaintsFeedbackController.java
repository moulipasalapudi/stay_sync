package com.staysync.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.staysync.dtos.ComplaintDto;
import com.staysync.dtos.FeedbackDto;
import com.staysync.service.ComplaintService;
import com.staysync.service.FeedbackService;

@RestController
public class ComplaintsFeedbackController {

    @Autowired
    private ComplaintService complaintService;
    @Autowired
    private FeedbackService feedbackService;

    // TENANT APIs

    // POST /tenants/complaints
    @PostMapping("/tenants/complaints")
    public void fileComplaint(@RequestBody ComplaintDto dto) {
        complaintService.fileComplaint(dto);
    }

    // GET /tenants/complaints?tenantId=2
    @GetMapping("/tenants/complaints")
    public List<ComplaintDto> getComplaints(@RequestParam Long tenantId) {
        return complaintService.getComplaintsByTenant(tenantId);
    }

    // POST /tenants/feedback
    @PostMapping("/tenants/feedback")
    public void submitFeedback(@RequestBody FeedbackDto dto) {
        feedbackService.submitFeedback(dto);
    }

    // GET /tenants/feedback?tenantId=2
    @GetMapping("/tenants/feedback")
    public List<FeedbackDto> getFeedback(@RequestParam Long tenantId) {
        return feedbackService.getFeedbackByTenant(tenantId);
    }

    // OWNER APIs

    // GET /owners/pgs/{pgId}/complaints
    @GetMapping("/owners/pgs/{pgId}/complaints")
    public List<ComplaintDto> getPgComplaints(@PathVariable Long pgId) {
        return complaintService.getComplaintsByPg(pgId);
    }

    // PUT /owners/complaints/{complaintId}/resolve
    @PutMapping("/owners/complaints/{complaintId}/resolve")
    public void resolveComplaint(@PathVariable Integer complaintId) {
        complaintService.resolveComplaint(complaintId);
    }
}