package com.example.test.service.impl;

import com.example.test.service.BoardService;
import com.example.test.service.mapper.BoardDAO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDAO boardDAO;

    @Override
    public List<Map<String, Object>> getBoards() throws Exception {
        return boardDAO.getBoards();
    }
}