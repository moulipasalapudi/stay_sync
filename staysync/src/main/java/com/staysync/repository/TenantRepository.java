package com.staysync.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.staysync.models.Tenant;

public interface TenantRepository extends JpaRepository<Tenant, Long> {

    
}
