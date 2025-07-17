package com.staysync.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.staysync.models.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    List<Feedback> findByTenantId(Long tenantId);
}