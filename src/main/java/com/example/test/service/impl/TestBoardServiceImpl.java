package com.example.test.service.impl;

import com.example.test.service.TestBoardService;
import com.example.test.vo.BoardType;
import org.springframework.stereotype.Service;

@Service
public class TestBoardServiceImpl implements TestBoardService {

    @Override
    public void getBoardType(BoardType boardType) {
        System.out.println("================="+boardType.getBoardType());
    }
}
