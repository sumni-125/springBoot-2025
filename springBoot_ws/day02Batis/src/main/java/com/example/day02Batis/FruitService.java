package com.example.day02Batis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitService {

    @Autowired
    FruitRepository repository;

    public List<Fruit> selectAll(){
        return repository.selectAll();
    }

    public int insertFruit(Fruit f){
        return repository.insertFruit(f);
    }


}
