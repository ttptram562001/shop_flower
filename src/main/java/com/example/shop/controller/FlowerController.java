package com.example.shop.controller;

import com.example.shop.model.Flower;
import com.example.shop.service.FlowerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.Flow;

@RestController
@RequestMapping("/api/flowers")
public class FlowerController {

    @Autowired
    private  FlowerServiceImpl service;

    @GetMapping("/{id}")
    public ResponseEntity<Flower> getFlowerById(@PathVariable(name = "id") Integer id) {
        return new ResponseEntity(service.getFlowerById(id), HttpStatus.OK);
    }

    @PostMapping(produces = "text/plain;charset=UTF-8")
    public ResponseEntity<Flower> addProduct(@RequestBody Flower flower)  {
        return new ResponseEntity(service.addFlower(flower), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Flower>> searchFlower(@RequestParam(name = "key-word") String keyword) {
        return new ResponseEntity<>(service.searchFlower(keyword), HttpStatus.OK);
    }
}
