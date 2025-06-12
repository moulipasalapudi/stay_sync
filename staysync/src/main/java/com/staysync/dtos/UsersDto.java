package com.staysync.dtos;


import com.staysync.models.Enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsersDto {
    private long id;
    private String name;
    private String email;
    private Role role;
}
