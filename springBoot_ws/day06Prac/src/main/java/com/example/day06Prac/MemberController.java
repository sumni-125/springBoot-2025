package com.example.day06Prac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MemberController {

    //
    @Autowired
    MemberRepository repository;
    //

    @GetMapping("/memberList")
    public String getMembers(Model model) {
        List<Member> list = repository.selectAll();
        model.addAttribute("list", list);
        return "memberListAll";
    }

    @GetMapping("/list")
    public String getMemnersPage(
            @RequestParam(name = "currentPage", required = false, defaultValue = "1") int currentPage
            , Model model
    ) {
        int pageSize = 2;
        int grpSize = 5;
        int totalCount = 0;

        totalCount = repository.countAll();

        //페이징관련정보
        PageHandler pageHandler = new PageHandler(currentPage, pageSize, grpSize, totalCount);
        System.out.println(pageHandler);

        //리스트정보
        List<Member> list = repository.selectPage(currentPage, pageSize);

        model.addAttribute("pageHandler", pageHandler);
        model.addAttribute("list", list);


        return "list";
    }

}
