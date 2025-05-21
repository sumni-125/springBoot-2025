package com.example.day06Prac;

public class PageHandlerMain {
    public static void main(String[] args) {

        //페이징 관련 데이터 처리

        //1. 현재페이지( 기본값:1, 사용자가 선택한 페이기 )
        //2. 한 페이지에 보이는 글의 수( 페이지 사이즈 )
        //3. 그룹의 사이즈: 그룹에 포함되는 페이지 수
        //4. 전체 레코드 수: db

        //5. 전체 페이지 수 구하기( 전체 레코드 수 / 페이지 사이즈 ), 나머지가 있다 -> +1
        //6. 현재 페이지에 대한 현재 그룹 구하기
        //7. 현재 그룹에 대한 그룹 시작과 끝 구하기
        //      그룹 시작 :  현재 그룹 -1
        //      그룹 끝ㅇ :  현재 그룹 * 그룹사이즈
        //8. 그룹의 끝 확인하기( 그룹의 끝이 전체 페이지 수보다 큰지 확인하기 )
        //9. 현재 그룹의 시작 ~ 현재 그룹의 마지막까지 반복
        //10. 이전, 다음


        int currentPage;
        int pageSize;
        int grpSize;
        int totRecode;

        int totalPage;
        int currentGrp;
        int grpStartPage;
        int grpEndPage;

        currentPage=6;
        pageSize=4;
        grpSize=5;
        totRecode=37;

        int remain = totRecode%pageSize;
        if(remain==0){
            totalPage=totRecode/pageSize;
        }else{
            totalPage=(totRecode/pageSize)+1;
        }
        int remain2 = currentPage%grpSize;

        if(remain2==0){
            currentGrp = currentPage/grpSize;
        }else{
            currentGrp = (currentPage/grpSize)+1;
        }

        grpStartPage = (currentGrp-1)*grpSize+1;
        grpEndPage = currentGrp*grpSize;

        if(grpEndPage>totalPage){
            grpEndPage=totalPage;
        }
        /*
        currentPage;
        int pageSize;
        int grpSize;
        int totRecode;

        int totalPage;
        int currentGrp;
        int grpStartPage;
        int grpEndPage;
         */

        System.out.println(currentPage+" "+pageSize+" "+grpSize+" "+totRecode);
        System.out.println(totalPage+" "+currentGrp+" "+grpStartPage+" "+grpEndPage);

    }
}
