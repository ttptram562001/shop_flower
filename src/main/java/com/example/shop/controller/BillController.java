package com.example.shop.controller;

import com.example.shop.model.Bill;
import com.example.shop.model.User;
import com.example.shop.service.BillServiceImpl;
import com.example.shop.service.FootwearServiceImpl;
import com.example.shop.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/bills")
public class BillController {

    @Autowired
    private BillServiceImpl service;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private FootwearServiceImpl footwearService;

    @GetMapping("/{id}")
    public ResponseEntity<Bill> getBillById(@PathVariable(name = "id") Integer id) {
        return new ResponseEntity(service.getBillById(id), HttpStatus.OK);
    }

    @GetMapping("/{id_user}")
    public ResponseEntity<List<Bill>> getBillByUser(@PathVariable(name = "id_user") Integer idUser) {
        User user = userService.getUserById(idUser);
        if (user == null)
            return ResponseEntity.badRequest().body(null);
        else
            return new ResponseEntity(service.getBillByUser(user), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Bill> createBill(@RequestParam(name = "amount") int amount,
                                           @RequestParam(name = "id_user") Integer idUser,
                                           @RequestParam(name = "id_footwear") Integer idFootwear)
    {
        if (userService.getUserById(idUser) == null || footwearService.getFootwearById(idFootwear) == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            Bill bill = new Bill();
            bill.setAmount(amount);
            bill.setBuyDate(new Date());
            bill.setFootwear(footwearService.getFootwearById(idFootwear));
            bill.setUser(userService.getUserById(idUser));
            bill.setTotal(amount * footwearService.getFootwearById(idFootwear).getPrice());
            return new ResponseEntity(service.createBill(bill), HttpStatus.OK);
        }
    }

}
