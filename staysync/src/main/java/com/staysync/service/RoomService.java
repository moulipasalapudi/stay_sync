package com.staysync.service;

import java.util.List;

import com.staysync.dtos.RoomDto;

public interface RoomService {

    void saveRoomDetails(RoomDto roomDto);

    RoomDto getRoomDetailsById(Long id);

    List<RoomDto> getAllRoomDetails();

    void updateRoomDetails(Long id, RoomDto roomDto);

    void deleteRoomDetails(Long id);

    List<RoomDto> searchRoomDetails(String query);

    List<RoomDto> filterRoomDetails(String location, String amenities, String priceRange);
    
}
