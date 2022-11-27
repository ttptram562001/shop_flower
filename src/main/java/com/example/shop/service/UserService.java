package com.example.shop.service;

import com.example.shop.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User login(String username, String password);
    User getUserById(Integer id);

}
