package com.staysync.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staysync.dtos.UsersDto;
import com.staysync.mapper.UserMapper;
import com.staysync.models.Users;
import com.staysync.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Override
    public UsersDto register(Users req) {
        // Convert Users to UsersDto
        UsersDto userDto = userMapper.toDto(req);
        
        // Save the user entity to the database
        Users savedUser = userRepository.save(req);
        
        // Convert saved Users entity back to UsersDto
        return userMapper.toDto(savedUser);
    }
    @Override
    public UsersDto login(Users req) {
        // Convert Users to UsersDto
        UsersDto userDto = userMapper.toDto(req);
        
        // Check if the user exists in the database
        Users existingUser = userRepository.findByEmailAndPassword(req.getEmail(), req.getPassword());
        
        if (existingUser != null) {
            // Convert existing Users entity back to UsersDto
            return userMapper.toDto(existingUser);
        } else {
            // Handle login failure (e.g., throw an exception or return null)
            return null;
        }

    }
    // @Override
    // public UsersDto getProfile() {


    // }
    // @Override
    // public UsersDto updateProfile(UsersDto userDto) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'updateProfile'");
    // }
    // @Override
    // public void deleteAccount() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'deleteAccount'");
    // }
    // @Override
    // public void sendVerificationEmail(String email) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'sendVerificationEmail'");
    // }
    // @Override
    // public boolean verifyEmail(String token) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'verifyEmail'");
    // }
    // @Override
    // public void sendPasswordResetEmail(String email) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'sendPasswordResetEmail'");
    // }
    // @Override
    // public boolean verifyPasswordResetToken(String token) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'verifyPasswordResetToken'");
    // }
    // @Override
    // public void updatePasswordWithToken(String token, String newPassword) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'updatePasswordWithToken'");
    // }
    

    


    
}
