package com.example.day05PracException;

import java.io.IOException;

public class 예외처리하기 {
    public static void main(String[] args) {
        // 콘솔로 부터 한 바이트 읽기

        //exception (checked 오류) :예외처리 필수
        //runtimeException (unchecked 오류): 예외처리 안해도됨


        //checked Exception - try ~ catch, throws
        int result=0;
        try {
            result = System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(result);
    }
}
