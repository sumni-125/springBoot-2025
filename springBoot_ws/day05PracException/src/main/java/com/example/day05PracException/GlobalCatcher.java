package com.example.day05PracException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;

//전역으로 커스텀 예외처리
//패키지 단위나
//전체단위로 예외처리 가능
@ControllerAdvice
public class GlobalCatcher {

    //서버가 오류를 처리하면 상태코드가 200으로 자동 설정됨
    //그래서 상태코드를 변경해야함
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(SQLException.class)
    public String catcher(){
        return "errSQL";
    }

}
