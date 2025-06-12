package com.staysync.mapper;


import org.mapstruct.Mapper;

import com.staysync.dtos.RoomDto;
import com.staysync.models.Room;


@Mapper(componentModel = "spring")
public interface RoomMapper {
    RoomDto toDto(Room room);
    Room toEntity(RoomDto dto);
}
