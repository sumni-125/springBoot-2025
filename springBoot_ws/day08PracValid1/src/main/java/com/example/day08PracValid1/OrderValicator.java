package com.example.day08PracValid1;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class OrderValicator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Order.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        //order객체=>target
        Order order = (Order) target;

        if(order.getName()==null || order.getName().isEmpty()){
            errors.rejectValue("name","required","ddd");
        }

        //금액검증
        if(order.getPrice()==null || order.getQty()<100 || order.getPrice()>10000){
            errors.rejectValue("name","range",new Object[]{"100","10000"}, "금액오류입니다");
        }

        //수량검증
        if( order.getQty()== null || order.getQty() >999){

            errors.rejectValue("qty","max" , new Object[]{"999"} , "999를 넘어갈 수 없다");

        }

    }
}
