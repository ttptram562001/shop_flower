package com.example.shop.service;

import com.example.shop.model.Footwear;
import com.example.shop.model.Type;

import java.util.List;

public interface TypeService {
    Type getByName(String name);
    List<Footwear> findFootwear(String name);
    Type getById(Integer id);
}
