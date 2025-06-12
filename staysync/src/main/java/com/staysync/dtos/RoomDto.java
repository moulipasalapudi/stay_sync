package com.staysync.dtos;

import lombok.Data;

@Data
public class RoomDto {
    private long id;
    private String roomNumber;
    private Integer rent;
    private Integer capacity;
    private Boolean isVacant;
    private String amenities;
    private Long pgId;
    
}
