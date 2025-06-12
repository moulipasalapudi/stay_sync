package com.staysync.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
public class MealPreference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String mealType; // e.g., Vegetarian, Non-Vegetarian, Vegan
    private boolean willEat;
    @OneToOne
    @JoinColumn(name = "tenant_id")
    private Tenant tenant;

    // Constructors, getters, and setters
    
}
