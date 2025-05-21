package com.example.day06Prac;

public class PageHandler {

    int currentPage;
    int pageSize;
    int grpSize;
    int totRecode;

    int totalPage;
    int currentGrp;
    int grpStartPage;
    int grpEndPage;

    public PageHandler(int currentPage, int pageSize, int grpSize, int totRecode) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.grpSize = grpSize;
        this.totRecode = totRecode;
        pageCalc();
    }

    private void pageCalc(){
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

        System.out.println(currentPage+" "+pageSize+" "+grpSize+" "+totRecode);
        System.out.println(totalPage+" "+currentGrp+" "+grpStartPage+" "+grpEndPage+"\n");

    }


    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotRecode() {
        return totRecode;
    }

    public void setTotRecode(int totRecode) {
        this.totRecode = totRecode;
    }

    public int getGrpSize() {
        return grpSize;
    }

    public void setGrpSize(int grpSize) {
        this.grpSize = grpSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentGrp() {
        return currentGrp;
    }

    public void setCurrentGrp(int currentGrp) {
        this.currentGrp = currentGrp;
    }

    public int getGrpStartPage() {
        return grpStartPage;
    }

    public void setGrpStartPage(int grpStartPage) {
        this.grpStartPage = grpStartPage;
    }

    public int getGrpEndPage() {
        return grpEndPage;
    }

    public void setGrpEndPage(int grpEndPage) {
        this.grpEndPage = grpEndPage;
    }


}
