package com.staysync.models;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PgDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String location;
    private String amenities;
    private Integer rent;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Users owner;
    @OneToMany(mappedBy = "pgDetails", cascade = CascadeType.ALL)
    private List<Room> rooms;
    @OneToMany(mappedBy = "pgDetails", cascade = CascadeType.ALL)
    private List<Payment> payments;
    @OneToMany(mappedBy = "pgDetails", cascade = CascadeType.ALL)
    private List<Complaints> complaints;
    @OneToMany(mappedBy = "pgDetails", cascade = CascadeType.ALL)
    private List<Tenant> tenants;
    @OneToMany(mappedBy = "pgDetails", cascade = CascadeType.ALL)
    private List<TenantRequests> tenantRequests;

}
