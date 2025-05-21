package com.example.day06Prac;

public class Main {
    public static void main(String[] args) {
        int currentPage=9;
        int pageSize=7;
        int grpSize=6;
        int totRecode=513;
        PageHandler handler = new PageHandler(currentPage,pageSize,grpSize,totRecode);

        int start = handler.getGrpStartPage();
        int end = handler.getGrpEndPage();

        System.out.println(handler.getTotalPage()+" "+handler.getCurrentGrp()+" "+handler.getGrpStartPage()+" "+handler.getGrpEndPage());

        System.out.println("\n"+start);
        System.out.println(end);

        if(handler.getGrpStartPage()>1){
            System.out.println(handler.getGrpStartPage()-1);
            System.out.print("이전 ");

        }

        for(int i=start;i<=end;i++){
            System.out.print("["+i+"] ");
        }

        if(handler.getGrpEndPage()<handler.getTotalPage()){
            System.out.print("다음 \n");
            System.out.println(handler.getGrpEndPage()+1);
        }
    }
}
