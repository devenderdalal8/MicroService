package com.example.user.controller;

import com.example.user.entity.User;
import com.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    //create user
    @PostMapping
    ResponseEntity<User> create(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(user));

    }

    //get user
    @GetMapping("/{id}")
    ResponseEntity<User> getUser(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(id));
    }
    // get all users
    @GetMapping
    ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }
    //update user


    //delete user
}
