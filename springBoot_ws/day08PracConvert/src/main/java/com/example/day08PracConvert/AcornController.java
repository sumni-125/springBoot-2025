package com.example.day08PracConvert;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//에이콘 학생 등록 서비스


@Controller
public class AcornController {

    @GetMapping("/acornForm")
    public String acornForm(@ModelAttribute Acorn acorn){
        return "acornForm";
    }
    @PostMapping("/acorn")
    public String acorn(@ModelAttribute Acorn acorn){
        return "redirect:/home";
    }

}
