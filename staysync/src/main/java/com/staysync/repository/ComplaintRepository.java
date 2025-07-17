package com.staysync.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.staysync.models.Complaints;

public interface ComplaintRepository extends JpaRepository<Complaints, Integer> {
    
    List<Complaints> findByTenant_Id(Long tenantId);
    List<Complaints> findByPgDetailsId(Long pgId);
}
  