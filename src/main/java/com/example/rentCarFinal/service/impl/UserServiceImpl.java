package com.example.rentCarFinal.service.impl;

import com.example.rentCarFinal.convertor.UserConvertor;
import com.example.rentCarFinal.dto.*;
import com.example.rentCarFinal.entity.User;
import com.example.rentCarFinal.exception.RecordNotFoundException;
import com.example.rentCarFinal.repository.UserRepository;
import com.example.rentCarFinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {

    private final UserConvertor userConvertor;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserServiceImpl(UserConvertor userConvertor, UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userConvertor = userConvertor;
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserResponse addUser(UserRequest userRequest) throws RecordNotFoundException {
        User userToBeSaved = userConvertor.toString(userRequest);
        return userConvertor.toResponse(userRepository.save(userToBeSaved));
    }

    @Override
    public void deleteUser(Long id) {

        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(UserUpdatePassword userUpdatePassword) throws RecordNotFoundException {
        Optional<User> user = userRepository.findById(userUpdatePassword.getId());
        if (user.isEmpty()) {
            throw new RecordNotFoundException("User not found or invalid credentials");
        } else if (!bCryptPasswordEncoder.matches(
                userUpdatePassword.getPassword(),
                user.get().getPassword())) {
            throw new RecordNotFoundException("User not found or password is wrong");
        } else {
            user.get().setPassword(userUpdatePassword.getNewPassword());
        }
    }

    @Override
    public UserResponse getUserById(Long id) throws RecordNotFoundException {
        return userConvertor.toResponse(userRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException(String.format("Id %s not found", id))));
    }

    @Override
    public UserResponse login(LoginRequest loginRequest) throws RecordNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(loginRequest.getEmail()));
        if (user.isEmpty()) {
            throw new RecordNotFoundException("User not found or invalid credentials");
        } else if (bCryptPasswordEncoder.matches(loginRequest.getPassword(), user.get().getPassword())) {
            throw new RecordNotFoundException("User not found or password is wrong");
        }
        return userConvertor.toResponse(user.get());
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }
}
