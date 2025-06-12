package com.staysync.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.staysync.models.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {


    
}