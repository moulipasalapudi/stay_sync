package com.staysync.models;

import java.time.LocalDate;

import com.staysync.models.Enums.TenantStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class TenantRequests {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate requesDate;
    @Enumerated(EnumType.STRING)
    private TenantStatus status;
    @ManyToOne
    @JoinColumn(name = "potential_tenant_id")
    private Users potentialTenant;

    @ManyToOne
    @JoinColumn(name = "pg_id")
    private PgDetails pgDetail;

    
}
// Removed TenantStatus enum to place it in its own file
