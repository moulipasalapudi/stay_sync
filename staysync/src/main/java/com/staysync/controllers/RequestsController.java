package com.staysync.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.staysync.dtos.TenantRequestDto;
import com.staysync.service.RequestService;

@RestController
@RequestMapping("/api/requests")
public class RequestsController {
    @Autowired
    private RequestService requestService;

    @PostMapping("/join")
    public void createJoinRequest(@RequestBody TenantRequestDto req) {
        requestService.createJoinRequest(req);
    }
    @GetMapping("/pg-requests/{pgId}")
    public List<TenantRequestDto> getPGRequests(@PathVariable Long pgId) {
        return requestService.getPGRequests(pgId);
    }
    @PutMapping("/approve")
    public void approveRequest(@RequestBody Long requestId) {
        requestService.approveRequest(requestId);
    }

    @PutMapping("/reject")
    public void rejectRequest(@RequestBody Long requestId) {
        requestService.rejectRequest(requestId);
    }
}
