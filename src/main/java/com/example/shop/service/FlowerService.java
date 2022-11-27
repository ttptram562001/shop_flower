package com.example.shop.service;

import com.example.shop.model.Flower;

import java.util.List;

public interface FlowerService {
    Flower addFlower(Flower newFlower);
    List<Flower> getAllFlower();
    Flower getFlowerById(Integer id);
    List<Flower> searchFlower(String name);
}
