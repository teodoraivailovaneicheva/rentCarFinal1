package com.example.rentCarFinal.service;

import com.example.rentCarFinal.dto.*;
import com.example.rentCarFinal.entity.User;
import com.example.rentCarFinal.exception.RecordNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserResponse addUser (UserRequest user) throws RecordNotFoundException;
    void updateUser(UserUpdatePassword userUpdatePassword) throws RecordNotFoundException;
    UserResponse getUserById(Long id) throws RecordNotFoundException;
    void deleteUser(Long id);
    UserResponse login(LoginRequest loginRequest) throws RecordNotFoundException;
    User getUserByEmail(String email);


}
