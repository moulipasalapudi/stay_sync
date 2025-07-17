package com.staysync.dtos;

import java.time.LocalDate;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedbackDto {
    private Integer id;
    private Long tenantId;
    private Long pgId;
    private String content;
    private Integer rating;
    private LocalDate createdAt;
}