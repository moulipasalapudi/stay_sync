package com.staysync.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.staysync.models.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    
}
