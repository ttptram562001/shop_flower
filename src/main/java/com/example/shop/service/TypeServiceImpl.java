package com.example.shop.service;

import com.example.shop.model.Footwear;
import com.example.shop.model.Type;
import com.example.shop.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements  TypeService{
    @Autowired
    private TypeRepository repository;

    @Override
    public Type getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Footwear> findFootwear(String name) {
        return (List<Footwear>) repository.findByName(name).getFootwears();
    }

    @Override
    public Type getById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
