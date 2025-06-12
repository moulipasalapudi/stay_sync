package com.staysync.dtos;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TenantRequestDto {
    private Long id;
    private Long potentialTenantId;
    private Long pgId;
    private LocalDate requestDate;
    private com.staysync.models.Enums.TenantStatus status;

    
}
