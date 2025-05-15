package com.example.day03;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BoardRepositoryTest {
    @Autowired
    BoardRepository boardRepository;

    @Test
    public void test(){
        SearchCondition sc = new SearchCondition();
        sc.setCondition("content");
        sc.setKeyword("다형성");

        int s =boardRepository.selectBoard(sc).size();
        assertTrue(s==1);
    }

}