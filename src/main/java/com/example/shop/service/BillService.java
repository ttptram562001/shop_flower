package com.example.shop.service;

import com.example.shop.model.Bill;
import com.example.shop.model.User;

import java.util.List;

public interface BillService {
    List<Bill> getBillByUser(User user);
    Bill createBill(Bill newBill);
    Bill getBillById(Integer id);
}
