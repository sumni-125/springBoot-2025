package com.example.tranEx;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @Autowired
    MemberService service;
    
    /*
    회원가입시 포인트 적립을 해 준다
    
    회원가입(모두 성공)
    - 회원 테이블에 등록
    - 포인트 테이블에 회원의 포인트가 등록
    
    => 하나의 논리적 단위로 묶어서 모두 수행되거나 모두 수행되지 않도록 한다(트랜잭션)

     */



    @GetMapping("/join")
    public String  join(){

        Member  member= new Member();
        member.setId("acorn");
        member.setName("홍길동");


        service.회원가입포인트적립(member);
        return "ok";
    }

}
