package com.example.day02Batis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FruitController {

    @Autowired
    FruitService service;

    @GetMapping("/selectFruits")
    public String selectFruits(Model model){
        model.addAttribute("list", service.selectAll());
        return "fruitList";
    }

    @GetMapping("/registForm")
    public String registForm(Model model){

        return "registForm";
    }

    @PostMapping("/registFruit")
    public String registFruits(@ModelAttribute Fruit fruit){
        System.out.println(fruit);
        service.insertFruit(fruit);
        return "redirect:/selectFruits";
    }

}
