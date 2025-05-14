package com.example.day02Batis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FruitRepository {

    @Autowired
    SqlSession session;

    public List<Fruit> selectAll(){
        return session.selectList("fruit.selectAll");
    }

    public int insertFruit(Fruit f){
        return session.insert("fruit.insert", f);
    }

}
