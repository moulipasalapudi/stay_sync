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
public class TenantDto {
    private Long id;
    private Long userId;
    private Long pgId;
    private Long roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Boolean active;
    private String status;
}
