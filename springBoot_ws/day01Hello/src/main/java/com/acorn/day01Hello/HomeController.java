package com.acorn.day01Hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/hello")
    public String hello(Model model){

        model.addAttribute("data", "spring boot start!!");

        return "hello";
    }

    @ResponseBody
    @GetMapping("/hello2")
    public String hello2(){
        return "hello";
    }


}
