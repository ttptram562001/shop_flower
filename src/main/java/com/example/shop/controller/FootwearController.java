package com.example.shop.controller;


import com.example.shop.model.Footwear;
import com.example.shop.service.FootwearServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/footwears")
public class FootwearController {

    @Autowired
    private FootwearServiceImpl service;

    @GetMapping
    public ResponseEntity<List<Footwear>> getAllFootwear() {
        return new ResponseEntity(service.getAllFootwear(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Footwear> getFootwearById(@PathVariable(name = "id") Integer id) {
        if (service.getFootwearById(id) == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return new ResponseEntity(service.getFootwearById(id), HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<Footwear> addFootwear(@RequestParam(name = "name") String name,
                                                @RequestParam(name = "design") String design,
                                                @RequestParam(name = "image") String image,
                                                @RequestParam(name = "price") int price,
                                                @RequestParam(name = "description") String description) {
        Footwear footwear = new Footwear(name, design, image, price, description);
        return new ResponseEntity(service.addFootwear(footwear), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Footwear>> searchFootwear(@RequestParam(name = "keyword") String keyword) {
        return new ResponseEntity(service.searchFootwear(keyword), HttpStatus.OK);
    }
}
