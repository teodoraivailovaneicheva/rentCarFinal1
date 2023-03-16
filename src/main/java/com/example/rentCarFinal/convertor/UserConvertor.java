package com.example.rentCarFinal.convertor;

import com.example.rentCarFinal.dto.UserRequest;
import com.example.rentCarFinal.dto.UserResponse;
import com.example.rentCarFinal.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserConvertor {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    public User toUser(UserRequest userRequest){

        return User.builder().firstName(userRequest.getFirstName())
                .lastName(userRequest.getLastName())
                .email(userRequest.getEmail())
                .password(bCryptPasswordEncoder.encode( userRequest.getPassword()))
                .build();
    }

    public UserResponse toResponse (User user){
        return UserResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .build();

    }

    public User toString(UserRequest userRequest) {
        return null;
    }
}
