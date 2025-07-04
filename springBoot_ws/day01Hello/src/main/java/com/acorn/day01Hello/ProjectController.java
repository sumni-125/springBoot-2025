package com.acorn.day01Hello;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProjectController {

    //1조
    @GetMapping("/team1")
    public String getMembers(Model model){
        List<User> team1 = new ArrayList<>();

        team1.add(new User("acorn1","윤현기","010-9336-4282"));
        team1.add(new User("acorn2","권지언","010-4699-6749"));
        team1.add(new User("acorn3","임형택","010-9959-8251"));
        team1.add(new User("acorn4","이수민","010-8383-7869"));
        team1.add(new User("acorn5","김보성","010-7766-5927"));

        model.addAttribute("team1",team1);

        return "team1";
    }



    //2조
    @GetMapping("/team2")
    public String getMembers2(Model model){
        List<User> team2 = new ArrayList<>();

        team2.add(new User("acorn1","정연수","010-4853-7624"));
        team2.add(new User("acorn2","김유민","010-3609-4215"));
        team2.add(new User("acorn3","이정호","010-8940-5832"));
        team2.add(new User("acorn4","김민환","010-7766-5927"));
        team2.add(new User("acorn5","황예지","010-3827-5448"));
        team2.add(new User("acorn6","오윤석","010-5344-3615"));


        model.addAttribute("team2",team2);

        return "team2";
    }





    //3조
    @GetMapping("/team3")
    public String getMembers3(Model model){
        List<User> team3 = new ArrayList<>();

        team3.add(new User("acorn1","최지태","010-2063-5040"));
        team3.add(new User("acorn2","박시우","010-8666-7993"));
        team3.add(new User("acorn3","박예린","010-5386-2795"));
        team3.add(new User("acorn4","박수경","010-3272-9011"));
        team3.add(new User("acorn5","최하은","010-7766-5927"));
        team3.add(new User("acorn6","이동우","010-2477-5476"));


        model.addAttribute("team3",team3);

        return "team3";
    }

    @GetMapping("/teamall")
    public String getProjectAll(Model model){

        List<User> team1 = new ArrayList<>();

        team1.add(new User("acorn1","윤현기","010-9336-4282"));
        team1.add(new User("acorn2","권지언","010-4699-6749"));
        team1.add(new User("acorn3","임형택","010-9959-8251"));
        team1.add(new User("acorn4","이수민","010-8383-7869"));
        team1.add(new User("acorn5","김보성","010-7766-5927"));

        List<User> team2 = new ArrayList<>();
        team2.add(new User("acorn1","정연수","010-4853-7624"));
        team2.add(new User("acorn2","김유민","010-3609-4215"));
        team2.add(new User("acorn3","이정호","010-8940-5832"));
        team2.add(new User("acorn4","김민환","010-7766-5927"));
        team2.add(new User("acorn5","황예지","010-3827-5448"));
        team2.add(new User("acorn6","오윤석","010-5344-3615"));

        List<User> team3 = new ArrayList<>();
        team3.add(new User("acorn1","최지태","010-2063-5040"));
        team3.add(new User("acorn2","박시우","010-8666-7993"));
        team3.add(new User("acorn3","박예린","010-5386-2795"));
        team3.add(new User("acorn4","박수경","010-3272-9011"));
        team3.add(new User("acorn5","최하은","010-7766-5927"));
        team3.add(new User("acorn6","이동우","010-2477-5476"));

        Map<String, List<User>> map = new HashMap<String, List<User>>();
        map.put("1",team1);
        map.put("2",team2);
        map.put("3",team3);
        model.addAttribute("teamall", map);

        return "teamAll";

    }

}
