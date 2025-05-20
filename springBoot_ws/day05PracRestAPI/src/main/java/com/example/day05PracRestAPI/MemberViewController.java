package com.example.day05PracRestAPI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberViewController {

    @GetMapping("/memberList")
    public String memberList(){
        return "memberList";
    }

    //멤버등록하기 화면제공
    @GetMapping("/memberRegister")
    public  String memberRegister(){
        return "memberRegister";
    }

    @GetMapping("/memberOne")
    public  String memberOne(){
        return "memberOne";
    }

    @GetMapping("/memberDelete")
    public  String memberDelete(){
        return "memberDelete";
    }
}
