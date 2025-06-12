package com.staysync.dtos;

import java.time.LocalDate;

import com.staysync.models.Enums.BillStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDto {
    private Long id;
    private Long tenantId;
    private Long pgId;
    private LocalDate paymentDate;
    private Integer amount;
    private BillStatus status;

    private String paymentMethod; // "rent" or "security"
    
}
