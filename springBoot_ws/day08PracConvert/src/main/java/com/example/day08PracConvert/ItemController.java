package com.example.day08PracConvert;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Controller
public class ItemController {
    @GetMapping("/itemForm")
    public String itemForm(){
        return "itemForm";
    }
    @PostMapping("/item")
    public String item(@ModelAttribute Item item){
        log.info( "item ={}" , item);

        return "redirect:/home";
    }

    //컨버터 등록하기
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        //날짜
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }


}
