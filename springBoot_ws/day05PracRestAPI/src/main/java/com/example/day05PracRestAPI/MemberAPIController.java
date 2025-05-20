package com.example.day05PracRestAPI;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//데이터 응답하기
//@ResponseBody
// ResponseEntity

// 모든 매핑에 ResponseBody 생략가능
@RestController
public class MemberAPIController {

    //서버에게 데이터 응답하기
    //요청이름 => 명사형태
    //요청구분 => method 타입으로 구분
    //@ResponseBody
    @GetMapping("/members")
    public List<Member> memberList(){

        List<Member> list = new ArrayList<>();
        list.add(new Member("acorn1","브래드피트","bread@gmail.com"));
        list.add(new Member("acorn2","키아누리브스","키아누@gmail.com"));
        list.add(new Member("acorn3","리차드막스","리차드@gmail.com"));

        return list;
    }

    //회원 등록하기
    //@ResponseBody
    @PostMapping("/members")        //리퀘스트바디로 요청온것을보내줘
    public  String memberRegister(@RequestBody Member member){
        System.out.println(member);
        
        //서비스. repository=>데이터베이스 등록

        return "성공";
    }
    //해당하는 고객의 정보 조회하기
    //자바스크립트 /members/acorn1
    //@ResponseBody
    @GetMapping("/members/{id}")
    public Member getMember(@PathVariable(name="id") String id){
        System.out.println(id);
        Member m = new Member("acorn1","브래드피트","bread@gmail.com");
        return m;
    }

    //@ResponseBody
    @DeleteMapping("/members/{id}")
    public String memberDelete(@PathVariable(name="id") String id){
        System.out.println(id);
        //서비스 -> repository -> 데이터베이스 삭제

        return "성공";
    }

}
