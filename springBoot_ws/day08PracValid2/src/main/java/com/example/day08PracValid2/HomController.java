package com.example.day08PracValid2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomController {

    @GetMapping("/home")
    public String home(){
        return "home";
    }
}
