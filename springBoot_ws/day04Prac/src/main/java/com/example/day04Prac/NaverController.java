package com.example.day04Prac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class NaverController {

    @Autowired
    NaverApi4 api;

    //data로 응답하기
    @ResponseBody
    @GetMapping(value="/naverData",  produces = "application/json;charset=utf-8")
    public String getData(){
        String data = api.getData();
        return data;
    }

    @ResponseBody
    @GetMapping("/naverList")
    public List<ItemDTO> getDataList(){
        String data = api.getData();
        return api.extracted(data);
    }

    @GetMapping("/naverView")
    public String getNaverList(Model model){

        model.addAttribute("list",api.extracted(api.getData()));

        return "naverView";
    }

}
