package com.staysync.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.staysync.models.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByEmailAndPassword(String email, String password);

    
}
