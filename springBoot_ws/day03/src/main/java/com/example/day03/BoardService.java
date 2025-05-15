package com.example.day03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    BoardRepository repository;

    public List<BoardDTO> getSearchBoare(SearchCondition search){
        return repository.selectBoard(search);
    }

}
