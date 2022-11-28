package com.example.shop.repository;

import com.example.shop.model.Footwear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FootwearRepository extends JpaRepository<Footwear, Integer> {
}
