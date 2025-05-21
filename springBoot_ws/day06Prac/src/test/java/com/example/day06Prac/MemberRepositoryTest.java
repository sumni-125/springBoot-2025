package com.example.day06Prac;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository repository;

    //@Test
    public void test1(){
        List<Member> list = repository.selectAll();

        System.out.println(list);
    }

    //@Test
    public void test2(){
        List<Member> list = repository.selectPage(2,4);

        System.out.println(list);
    }

    @Test
    public void test3(){
        int result = repository.countAll();
        assertTrue(result==13);
    }

}