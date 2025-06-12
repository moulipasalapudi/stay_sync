package com.staysync.mapper;

import org.mapstruct.Mapper;

import com.staysync.dtos.UsersDto;
import com.staysync.models.Users;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UsersDto toDto(Users user);
    Users toEntity(UsersDto dto);
}
