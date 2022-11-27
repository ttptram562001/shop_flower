package com.example.shop.service;

import com.example.shop.model.Bill;
import com.example.shop.model.User;
import com.example.shop.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService{

    @Autowired
    private BillRepository repository;
    @Override
    public List<Bill> getBillByUser(User user) {
        return repository.findByUser(user);
    }

    @Override
    public Bill createBill(Bill newBill) {
        return repository.save(newBill);
    }

    @Override
    public Bill getBillById(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
