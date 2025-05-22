package com.example.day07SessionPrac;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/loginForm")
    public String loginForm(@CookieValue(name="id", required = false, defaultValue = "") String id, Model model){
        model.addAttribute("id",id);
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user,
                        @RequestParam(name="rmid", required = false) boolean rmid,
                        HttpServletResponse response,
                        HttpServletRequest request
    ){
        System.out.println(user);
        if(!check(user)){
            return "redirect:/loginForm";
        }else{
            /*if(rmid){
                Cookie cookie = new Cookie("id",user.getId());
                cookie.setMaxAge(60*60*24);
                response.addCookie(cookie);
            }*/
            HttpSession session = request.getSession();
            // 사용자 세션을 얻어옴
            //기존에 사용자 세션이 있으면 있는 세션을 반환
            //세션이 없다면 새로운 세션을 반환

            session.setAttribute("USERID", user.getId());

            return "redirect:/home";
        }



    }

    boolean check(User user){
        if(user.getId().equals("user")&&user.getPw().equals("1234")){
            return true;
        }else{
            return false;
        }
    }

    @GetMapping("/logout")
    String logout(HttpServletRequest request){

        //세션정보 삭제하기
        HttpSession session = request.getSession(false);
        session.invalidate();
        //
        //session.removeAttribute("USERID");//USERID만 세션 삭제

        return "redirect:/home";
    }

}
