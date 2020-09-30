package com.example.test.service.impl;

import com.example.test.service.BoardService;
import com.example.test.service.mapper.BoardDAO;
import com.example.test.vo.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.modelmapper.ModelMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardDAO boardDAO;

    @Autowired
    private JPAQueryFactory queryFactory;

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Map<String, Object>> getBoards() throws Exception {
        return boardDAO.getBoards();
    }

    @Override
    public void update() {


    }
}