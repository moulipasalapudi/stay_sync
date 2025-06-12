package com.staysync.dtos;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PgDetailsDto {
    private long id;
    private String name;
    private String location;
    private String amenities;
    private Integer rent;
    private LocalDateTime createdAt;
    private Long ownerId;
    
}
