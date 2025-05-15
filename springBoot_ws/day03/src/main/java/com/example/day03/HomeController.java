package com.example.day03;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    /*
    home->main화면 보여주기
    main 화면에서 정보를 조회할 고객 선택하기
    선택한 고객의 정보 조회하기

    1) 사용자가 선택한 정보 여러개 얻어오기
    2) 얻어온 여러 고객 id로 고객 정보 조회하기
        - mapper작성시
        - select * from membertbl where id  in
        - in절 뒤의 내용을 동적으로 생성하기
        - foreach 사용하기
        - select * from membertbl where id  in ('acorn')
        - select * from membertbl where id  in ('acorn', 'acorn01')
        - select * from membertbl where id  in ('acorn', 'acorn01', 'acorn03')
     */

    @GetMapping("/home")
    public String home(){
        return "main";
    }


}
