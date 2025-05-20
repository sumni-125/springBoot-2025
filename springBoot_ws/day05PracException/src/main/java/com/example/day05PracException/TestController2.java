package com.example.day05PracException;
// 예외처리를 직접하기
// try ~ catch
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;

@Controller
public class TestController2 {

    @GetMapping("/method1")
    public String method1(){

        String viewName = "method1View";
        try {
            throw new SQLException("db 오류");

        } catch (SQLException e) {
            viewName="errSQL";
        }
        return viewName;
    }

    @GetMapping("/method2")
    public String method2(){

        String viewName = "method2View";
        try {
            throw new SQLException("db 오류");

        } catch (SQLException e) {
            viewName="errSQL";
        }
        return viewName;
    }

    @GetMapping("/method3")
    public String method3(){

        String viewName = "method3View";
        try {
            throw new SQLException("db 오류");

        } catch (SQLException e) {
            viewName="errSQL";
        }
        return viewName;
    }

    /*@GetMapping("/method2")
    public String method2(){
        
        int result=1;
        String viewName="";

        if(result==1){

            try {
                throw  new SQLException("데이터베이스 오류");
            } catch (SQLException e) {
                //throw new RuntimeException(e);
                viewName="errSQL";
            }
        }else if(result==2){
            viewName="method2View";
        }
        return viewName;
    }*/

}
