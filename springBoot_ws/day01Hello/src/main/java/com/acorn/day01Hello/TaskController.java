package com.acorn.day01Hello;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class TaskController {

    //두 수 더한 값을 반환 하는 문제
    //Task1Service
    @GetMapping("/calc")
    public String task1(
            @RequestParam(name="su1", required = false, defaultValue = "1") int su1,
            @RequestParam(name="su2", required = false, defaultValue = "1") int su2,
            Model model){
        int result=su1+su2;
        System.out.println(result);

        model.addAttribute("result", result);

        return "task1";
    }

    @ResponseBody
    @GetMapping("/dan3")
    public String task2(){
        int num=3;
        String str="<h2>3단 출력</h2>";

        for(int i=1;i<=9;i++){
            str+=num+" * "+i+" = "+i*num+"<br>";
        }

        return str;
    }

    @ResponseBody
    @GetMapping("/dan")
    public String task3(@RequestParam(name="num", required = false, defaultValue = "1") int num){

        String str="<h2>"+num+"단 출력</h2>";

        for(int i=1;i<=9;i++){
            str+=num+" * "+i+" = "+i*num+"<br>";
        }

        return str;
    }

    @GetMapping("/memberTask")
    public String task4(Model model){
        List<Member> list = new ArrayList<>();
        
        list.add(new Member("m01","1234","홍길동"));
        list.add(new Member("m02","1234","이수민"));
        list.add(new Member("m03","1234","박수경"));

        model.addAttribute("list", list);
        
        return "task4";
    }

    @ResponseBody
    @GetMapping("/star")
    public String task5(@RequestParam(name="cnt", required = false, defaultValue = "1") int cnt){
        String str="";
        for(int i=0;i<cnt;i++){
            str+="* ";
        }
        return str;
    }

    @GetMapping("/divisor")
    public String task6(@RequestParam(name="number", required = false, defaultValue = "1") int number,
    Model model){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=1;i<=number;i++){
            if(number%i==0){
                list.add(i);
            }
        }

        model.addAttribute("list",list);
        return "task6";
    }

    @ResponseBody
    @GetMapping("/message")
    public String task7(){
        return "화이팅~~";
    }

    @ResponseBody
    @GetMapping("/message/random")
    public String task8(){

        ArrayList<String> list = new ArrayList<>();
        list.add("화이팅~!");
        list.add("화이팅~~!!");
        list.add("화이팅~~~!!!");
        list.add("화이팅~~~~!!!!");
        list.add("화이팅~~~~~!!!!!");

        Random r = new Random();

        int index = r.nextInt(list.size());


        return list.get(index);
    }

    @GetMapping("/cute/img")
    public String task9(Model model){

        model.addAttribute("img","다운로드.jpg");
        return "task9";
    }

    @GetMapping("/cute/img/random")
    public String task10(Model model){

        ArrayList<String> list = new ArrayList<>();
        list.add("calc.jpg");
        list.add("images.png");
        list.add("다운로드.jpg");
        list.add("다운로드 (1).jpg");

        Random r = new Random();

        int index = r.nextInt(list.size());
        System.out.println(list.get(index));
        model.addAttribute("img",list.get(index));
        return "task9";
    }

    @Autowired
    Task11Service service11;

    @GetMapping("/calculator")
    public String task11(
            @RequestParam(name="s1", required = false, defaultValue = "1") int s1,
            @RequestParam(name="s2", required = false, defaultValue = "1") int s2,
            @RequestParam(name="c", required = false, defaultValue = "+") char c ,
            Model model
    ){

        switch (c){
            case '+':
                model.addAttribute("result",service11.add(s1,s2));
                break;
            case '-':
                model.addAttribute("result",service11.sub(s1,s2));
                break;
            case '*':
                model.addAttribute("result",service11.mul(s1,s2));
                break;
            case '/':
                model.addAttribute("result",service11.div(s1,s2));
                break;
            default:
                break;
        }

        model.addAttribute("s1",s1);
        model.addAttribute("s2",s2);
        model.addAttribute("c",c);

        return "task11";
    }
}
