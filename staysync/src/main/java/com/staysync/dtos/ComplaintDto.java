/* 
package com.staysync.dtos;

import java.time.LocalDate;

import com.staysync.models.Enums.ComplaintStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComplaintDto {
    private Long id;
    private Long tenantId;
    private Long pgId; // "maintenance" or "other"
    private String content;
    private ComplaintStatus status;
    private String attachments; // "open", "in progress", "resolved"
    private LocalDate createdAt;
    private LocalDate updatedAt;
    
}
*/
package com.staysync.dtos;

import java.time.LocalDate;
import com.staysync.models.Enums.ComplaintStatus;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComplaintDto {
    private Integer id;
    private Long tenantId;
    private Long pgId;
    private String content;
    private ComplaintStatus status;
    private String attachments;
    private LocalDate createdAt;
    private LocalDate updatedAt;
}