package com.example.shop.controller;

import com.example.shop.model.Footwear;
import com.example.shop.model.Type;
import com.example.shop.service.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/type")
public class TypeController {
    @Autowired
    private TypeServiceImpl service;

    @PostMapping
    public ResponseEntity<Type> getAllType(@RequestParam(name = "type") String name) {
        return new ResponseEntity(service.getByName(name), HttpStatus.OK);
    }

    @GetMapping("/footwears")
    public ResponseEntity<List<Footwear>> getFootwears(@RequestParam(name = "type") String name) {
        return new ResponseEntity(service.findFootwear(name), HttpStatus.OK);
    }

}
