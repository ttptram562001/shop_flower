package com.example.shop.service;

import com.example.shop.model.Footwear;
import com.example.shop.repository.FootwearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class FootwearServiceImpl implements FootwearService{
    @Autowired
    private FootwearRepository repository;

    @Override
    public Footwear addFootwear(Footwear newFootwear) {
        return repository.save(newFootwear);
    }

    @Override
    public List<Footwear> getAllFootwear() {
        return repository.findAll();
    }

    @Override
    public Footwear getFootwearById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Footwear> searchFootwear(String name) {
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        String[] keyword = name.trim().split("-");
        String type = pattern
                .matcher(Normalizer.normalize(keyword[0], Normalizer.Form.NFD))
                .replaceAll("")
                .toLowerCase();
        String design = pattern
                .matcher(Normalizer.normalize(keyword[1], Normalizer.Form.NFD))
                .replaceAll("")
                .toLowerCase();
        List<Footwear> footwears = new ArrayList();
        repository.findAll().forEach(it -> {
            String nameIt = pattern
                    .matcher(Normalizer.normalize(it.getName(), Normalizer.Form.NFD))
                    .replaceAll("")
                    .toLowerCase();
            String designIt = pattern
                    .matcher(Normalizer.normalize(it.getDesign(), Normalizer.Form.NFD))
                    .replaceAll("")
                    .toLowerCase();
            if (nameIt.contains(type) && designIt.contains(design)) {
                footwears.add(it);
            }
        });

        return footwears;
    }
}
