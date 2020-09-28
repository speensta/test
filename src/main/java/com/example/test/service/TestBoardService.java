package com.example.test.service;

import com.example.test.vo.Board;
import com.example.test.vo.BoardType;

import java.util.List;

public interface TestBoardService {

    List<Board> getBoardTest();
    void getBoardType(BoardType boardType);
}
