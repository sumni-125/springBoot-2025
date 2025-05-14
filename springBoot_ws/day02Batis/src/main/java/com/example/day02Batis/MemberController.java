package com.example.day02Batis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    //조회하기
    @GetMapping("/members")
    public String getMembers(Model model){

        List<Member> list = memberService.getMembers();
        model.addAttribute("list", list);
        return "memberList";
    }


    //등록화면
    @GetMapping("/form")
    public String form(){
        return "formview";
    }


    //등록하기
    @PostMapping("/formProc")
    public String formProc(@ModelAttribute Member member){

        System.out.println(member);
        memberService.registerMember(member);

        return "ok";
    }

}
