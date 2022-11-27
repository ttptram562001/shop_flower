package com.example.shop.controller;

import com.example.shop.model.User;
import com.example.shop.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl service;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser() {
        return new ResponseEntity(service.getAllUser(), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestParam(name = "username") String username,
                                      @RequestParam(name = "password") String password) {
        if (service.login(username, password) == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        else
            return new ResponseEntity(service.login(username, password), HttpStatus.OK);
    }
}
