package com.example.day02Batis;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    MemberRepository repository;

    //@Test
    public void test() {
        int result = repository.selectAll().size();
        assertTrue(result >= 1);
    }
    
   // @Test
    public void test2(){
        int result = repository.insert(new Member("a01","1234","홍길쓰"));
        assertTrue(result==1);
    }

    //@Test
    public void test3(){
        Member2 m = repository.selectAll2().get(0);
        System.out.println(m);

        String id = m.getM_id();
        assertNotNull(id);
    }

    @Test   //성공하지못하는게맞음.. 왜냐면 컬럼명이 달르니까 ㅋ
    public void test4(){
        Member2 m = repository.selectAll2().get(0);
        System.out.println(m);

        String id = m.getM_id();
        assertNotNull(m);
    }
}