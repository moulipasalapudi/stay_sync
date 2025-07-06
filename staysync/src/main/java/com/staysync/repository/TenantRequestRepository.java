package com.staysync.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.staysync.models.TenantRequests;

public interface TenantRequestRepository extends JpaRepository<TenantRequests, Long> {

    List<TenantRequests> findByPgDetailsId(Long pgId);

    
}
