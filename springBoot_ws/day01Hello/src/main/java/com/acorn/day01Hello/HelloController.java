package com.acorn.day01Hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello3")
    public String hello3(){
        return "hello3";
    }

    @GetMapping("/hello33")
    public String hello33(Model model){
        model.addAttribute("data","th사용입니당");
        return "hello3";
    }

}
