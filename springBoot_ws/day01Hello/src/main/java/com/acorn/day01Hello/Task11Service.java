package com.acorn.day01Hello;

import org.springframework.stereotype.Service;

@Service
public class Task11Service {

    public int add(int s1, int s2){
        return s1+s2;
    }

    public int sub(int s1, int s2){
        return s1-s2;
    }

    public int mul(int s1, int s2){
        return s1*s2;
    }

    public double div(int s1, int s2){
        return s1/(double)s2;
    }

}
