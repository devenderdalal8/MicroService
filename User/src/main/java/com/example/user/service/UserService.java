package com.example.user.service;

import com.example.user.entity.User;

import java.util.List;

public interface UserService {
    //save user
    User create(User user);
    // getAll list
    List<User> getAllUsers();

    // get by Id
    User getUser(String id);

}
