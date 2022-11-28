package com.example.shop.service;

import com.example.shop.model.Footwear;

import java.util.List;

public interface FootwearService {
    Footwear addFootwear(Footwear newFootwear);
    List<Footwear> getAllFootwear();
    Footwear getFootwearById(Integer id);
    List<Footwear> searchFootwear(String name);
}
