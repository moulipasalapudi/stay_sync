package com.staysync.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staysync.dtos.RoomDto;
import com.staysync.mapper.RoomMapper;
import com.staysync.repository.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService{
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private RoomMapper roomMapper;
    @Override
    public void deleteRoomDetails(Long id) {
        
    }
    @Override
    public List<RoomDto> filterRoomDetails(String location, String amenities, String priceRange) {

    }
    @Override
    public List<RoomDto> getAllRoomDetails() {

    }
    @Override
    public RoomDto getRoomDetailsById(Long id) {
    }
    @Override
    public void saveRoomDetails(RoomDto roomDto) {

        
    }
    @Override
    public List<RoomDto> searchRoomDetails(String query) {

    }
    @Override
    public void updateRoomDetails(Long id, RoomDto roomDto) {
        
    }
    
    
}
