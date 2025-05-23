package com.example.day08PracValid0;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public  String home(){
        return  "home";
    }
}
