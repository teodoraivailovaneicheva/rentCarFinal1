package com.example.rentCarFinal.controller;


import com.example.rentCarFinal.convertor.UserConvertor;
import com.example.rentCarFinal.dto.*;
import com.example.rentCarFinal.entity.User;
import com.example.rentCarFinal.exception.RecordNotFoundException;
import com.example.rentCarFinal.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {


    @Autowired
    private UserService userService;

    @Autowired
    private UserConvertor convertor;

    @Autowired
    public UserController(UserService userService, UserConvertor convertor) {
        this.userService = userService;
        this.convertor = convertor;
    }

    //Add new user
    @PostMapping("/addUser")
    ResponseEntity<UserResponse> addUser(@RequestBody UserRequest userRequest) throws RecordNotFoundException {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.addUser(userRequest));
    }

    @PostMapping(path = "/login")
    ResponseEntity<UserResponse> login(@RequestBody @Valid LoginRequest loginRequest) throws RecordNotFoundException {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.login(loginRequest));
    }

    //Update user password
    @PutMapping("/updatePassword")
    ResponseEntity<String> updateUser(@Valid @RequestBody UserUpdatePassword user) throws RecordNotFoundException {
        userService.updateUser(user);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body("Password changed");
    }

    //Delete user
    @DeleteMapping("/deleteUserById/{id}")
    ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity
                .ok()
                .body(String.format("%d deleted", id));
    }

    //Get user by id
    @GetMapping("/getUserById/{id}")
    ResponseEntity<UserResponse> getUserById(@PathVariable Long id) throws RecordNotFoundException {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(userService.getUserById(id));
    }

    //Get employee by email
    @GetMapping("/getUserByEmail/{email}")
    ResponseEntity<User> getUserByEmail(@PathVariable String email) throws RecordNotFoundException {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(userService.getUserByEmail(email));
    }
}

