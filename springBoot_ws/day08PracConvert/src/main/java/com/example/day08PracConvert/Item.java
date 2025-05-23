package com.example.day08PracConvert;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//대표적인 convert 오류
//null 일때-> 기본자료형 데이터를 담으려고 할 때
//"문자열"->int Integer 오류발생
//"2025/05/22"-> Date (문자열을 날짜타입으로 변환할 때)
//=> 400오류( request bad)

//변환오류 발생하면 오류화면 응답

@Data
public class Item {
    Long money;
    String name;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    Date inDate;

}
