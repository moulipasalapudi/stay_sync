package com.staysync.models;

import java.time.LocalDate;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Boolean active;
    private String status;
    @ManyToOne
    @JoinColumn(name="user_id")
    private Users user;
    @ManyToOne
    @JoinColumn(name="pg_id")
    private PgDetails pgDetails;
    @ManyToOne
    @JoinColumn(name="room_id")
    private Room room;
    @OneToOne(mappedBy = "tenant", cascade = CascadeType.ALL)
    private MealPreference mealPreference;

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    private List<Complaints> complaints;

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    private List<Payment> payments;
  
    // Add any other fields or relationships as needed


    
}
