package com.example.day03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MemberController {
    @Autowired
    MemberService service;

    @GetMapping("/memberSearch")
    public String searchMember(@RequestParam(name="userid") List<String> userid, Model model){
        System.out.println(userid);

        //서비스로부터 해당 고객 정보 리스트로 얻어오기
        
        //모델에 저장
        List<Member> list = service.getMember(userid);
        model.addAttribute("list", list);

        //뷰 응답
        return  "memberList";
    }
}
