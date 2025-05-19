package com.example.day04Prac;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MapController {

    @GetMapping("/map1")
    public String map1() {
        return "map1View";
    }

    @GetMapping("/map2")
    public String map2() {
        return "map2View";
    }

    @GetMapping("/map3")
    public String map3(Model model) {
        /*
            var positions = [
              {
                  title: '카카오',
                  latlng: new kakao.maps.LatLng(33.450705, 126.570677)
              },
              {
                  title: '생태연못',
                  latlng: new kakao.maps.LatLng(33.450936, 126.569477)
              },
              {
                  title: '텃밭',
                  latlng: new kakao.maps.LatLng(33.450879, 126.569940)
              },
              {
                  title: '근린공원',
                  latlng: new kakao.maps.LatLng(33.451393, 126.570738)
              }
           ];

           //각 각의 위치정보
           title
           lat
           lng
         */

        Item item1 = new Item("카카오~","33.450705","126.570677");
        Item item2 = new Item("생태연못~","33.450936","126.569477");
        Item item3 = new Item("텃밭~","33.450879","126.569940");
        Item item4 = new Item("근린공원~","33.451393","126.570738");

        List<Item> list = new ArrayList<>();
        list.add(item1);
        list.add(item2);
        list.add(item3);
        list.add(item4);

        //list => Gson 라이브러리 이용해서 json변환해서 모델로 저장
        //타임리프??를 사용하는 view에서는 json 벼환하지 않고 그냥 자바 객체로 전달가능
        //타임리프에서 th:inline 속성을 사용하면 자바 객체를 json으로 자동변화해줌
        System.out.println(list);
        model.addAttribute("list",list);

        return "map3View";
    }

}
