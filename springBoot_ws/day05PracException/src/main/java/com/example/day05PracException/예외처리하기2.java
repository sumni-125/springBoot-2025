package com.example.day05PracException;

public class 예외처리하기2 {

    public static void main(String[] args) {
        int money=-5000;
        int result=0;
        try {
            result =doubler(money);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("처리되지 않았습니다");
            throw new RuntimeException(e);
        }
        System.out.println("투자보고서");
        System.out.println("투자금액: "+money);
        System.out.println("투자결과: "+result);
        System.out.println("프로그램 정상 종료!");

    }

    //메서드만들기
    //int doubler(int money)

    public static  int doubler(int money) throws Exception {
        //modey가 음수면 예외를 발생시킴

        if(money<=0) throw new Exception("음수안돼~!");
        return  money*2;
    }
}
