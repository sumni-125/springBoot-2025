package com.example.day08PracValid2;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class OrderValidator implements Validator {

    // Order를 상속받은 객체인지 확인하기
    @Override
    public boolean supports(Class<?> clazz) {

        return Order.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {


        //order 객체  => tarket
        Order order  =  (Order)target;

        if( order.getName()==null  || order.getName().isEmpty()){
            errors.rejectValue("name" ,  "required" ,"dfdd");
        }



        //금액 검증
        if( order.getPrice()==null  || order.getQty() <100 || order.getPrice() >10000){

            errors.rejectValue("price" , "range" , new Object[]{"100" ,"10000"} , "금액오류입니다");
        }



        //수량검증
        if( order.getQty()== null || order.getQty() >999){

            errors.rejectValue("qty","max" , new Object[]{"999"} , "999를 넘어갈 수 없다");

        }

    }
}
