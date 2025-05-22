package com.example.day07PracCookie;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/home")
    public String home(@CookieValue(name="age", required = false) String age,
                       HttpServletResponse response){

        //쿠키정보 가져오기

        //쿠키 없는경우
        if(age==null){
            age="25";
            Cookie cookie = new Cookie("age",age);
            cookie.setMaxAge(60*60*24*365); //초 분 시간 day
            cookie.setPath("/");
            response.addCookie(cookie);
            return "home";
        }

        //쿠키 있는경우
        int ageInt=Integer.parseInt(age);
        String viewName="";

        if(ageInt>=20 && ageInt<=29){
            viewName="view20";
        } else if (ageInt>=30 && ageInt<=39) {
            viewName="view30";
        } else{
            viewName="view4050";
        }


        return viewName;
    }


}
