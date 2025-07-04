package com.example.day08PracValid1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class OrderController {
    @InitBinder
    public void init(WebDataBinder dataBinder){
        //validator 등록하기
        dataBinder.addValidators(new OrderValicator());
    }

    @GetMapping("/orderForm")
    public String orderForm(@ModelAttribute Order order){
        return "orderForm";
    }

    // 검증하려면
    /*
    1. 검증하려는 객체 뒤에 BindingResult bindingResult
    2. 검증객체 작성하기( validator 인터페이스를 구현해야한다 ), 에러코드 만들기
    3. 검증하는 객체 앞에 @Validated 붙여야한다
    4. 오류메시지 등록하기( 에러코드에 대한 에러메시지 작성하기)
    5. 뷰에서 에러가 있는 필드는 에러메시지가 나올 수 있게 한다
    6. validator 등록하기

     */

    @PostMapping("/order")
    public String order(
            @ModelAttribute @Validated Order order,
            BindingResult bindingResult
            ){
        log.info("item={}",order);
        if(bindingResult.hasErrors()){
            log.info( "bindingResult ={}" , bindingResult);
            return "orderForm";
        }
        return "redirect:/home";
    }

}
