package com.staysync.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.staysync.models.Users;
import com.staysync.service.UserService;
import com.staysync.dtos.UsersDto;
// import com.staysync.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UsersDto register(@RequestBody Users user) {
        return userService.register(user);
    }

    @PostMapping("/login")
    public UsersDto login(@RequestBody Users user) {
        return userService.login(user);
    }
}
