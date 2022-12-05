package com.example.shop.service;

import com.example.shop.model.Footwear;
import com.example.shop.model.Type;

import java.util.List;

public interface FootwearService {
    Footwear addFootwear(Footwear newFootwear);
    List<Footwear> getAllFootwear();
    List<Footwear> getByType(Type type);
    Footwear getFootwearById(Integer id);
    List<Footwear> searchFootwear(String name);
}
