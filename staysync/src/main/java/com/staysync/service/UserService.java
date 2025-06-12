package com.staysync.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staysync.dtos.UsersDto;
import com.staysync.mapper.UserMapper;
import com.staysync.models.Users;
import com.staysync.repository.UserRepository;
public interface UserService {
    UsersDto register(Users req);
    UsersDto login(Users req);
    // UsersDto getProfile();
    // UsersDto updateProfile(UsersDto userDto);
    // void deleteAccount();
    // // void changePassword(ChangePasswordRequest req);
    // // void resetPassword(ResetPasswordRequest req);
    // void sendVerificationEmail(String email);
    // boolean verifyEmail(String token);
    // void sendPasswordResetEmail(String email);
    // boolean verifyPasswordResetToken(String token);
    // void updatePasswordWithToken(String token, String newPassword);


}
