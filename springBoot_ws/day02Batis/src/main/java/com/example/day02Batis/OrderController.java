package com.example.day02Batis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    OrderService service;

    //조회하기
    @GetMapping("/orders")
    public List<Map<String, Object>> getOrders(Model model){

        List<Map<String, Object>> list = service.getOrderList();
        model.addAttribute("list", list);
        return list;
    }



}
