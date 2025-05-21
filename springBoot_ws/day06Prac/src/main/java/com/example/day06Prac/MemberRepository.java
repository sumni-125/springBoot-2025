package com.example.day06Prac;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemberRepository {

    @Autowired
    SqlSession session;

    public List<Member> selectAll() {
        return session.selectList("a.selectAll");
    }

    public List<Member> selectPage(int currentPage, int pageSize) {
        int end = currentPage * pageSize;
        int start = (currentPage - 1) * pageSize + 1;

        //매개변수를 객체로 사용해야 함
        Map<String, Integer> pageInfo = new HashMap<>();
        pageInfo.put("start", start);
        pageInfo.put("end", end);

        return session.selectList("a.selectPage", pageInfo);
    }

    public  int  countAll(){
        return session.selectOne("a.selectCount");
    }
}