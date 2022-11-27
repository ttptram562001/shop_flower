package com.example.shop.service;

import com.example.shop.model.Flower;
import com.example.shop.repository.FlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class FlowerServiceImpl implements FlowerService{
    @Autowired
    private FlowerRepository repository;

    @Override
    public Flower addFlower(Flower newFlower) {
        return repository.save(newFlower);
    }

    @Override
    public List<Flower> getAllFlower() {
        return repository.findAll();
    }

    @Override
    public Flower getFlowerById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Flower> searchFlower(String name) {
        String temp = Normalizer.normalize(name, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        String curName = pattern.matcher(temp).replaceAll("").toLowerCase();

        List<Flower> flowers = new ArrayList<>();
        repository.findAll().forEach(it -> {
            String tempIt =  Normalizer.normalize(it.getName(), Normalizer.Form.NFD);
            String curIt = pattern.matcher(tempIt).replaceAll("").toLowerCase();
            if (curIt.contains(curName)) flowers.add(it);
        });
        return flowers;
    }
}
