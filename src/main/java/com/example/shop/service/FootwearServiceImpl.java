package com.example.shop.service;

import com.example.shop.model.Footwear;
import com.example.shop.model.Type;
import com.example.shop.repository.FootwearRepository;
import com.example.shop.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FootwearServiceImpl implements FootwearService{
    @Autowired
    private FootwearRepository repository;

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public Footwear addFootwear(Footwear newFootwear) {
        return repository.save(newFootwear);
    }

    @Override
    public List<Footwear> getAllFootwear() {
        return repository.findAll();
    }

    @Override
    public List<Footwear> getByType(Type type) {
        return repository.findByType(type);
    }


    @Override
    public Footwear getFootwearById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Footwear> searchFootwear(String name) {
        System.out.println(typeRepository.findByName(name).toString());
        return (List<Footwear>) typeRepository.findByName(name).getFootwears();

    }
}
