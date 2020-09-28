package com.example.test.service.impl;

import com.example.test.service.TestBoardService;
import com.example.test.vo.Board;
import com.example.test.vo.BoardType;
import com.example.test.vo.QBoard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class TestBoardServiceImpl implements TestBoardService {

    @Autowired
    private JPAQueryFactory queryFactory;

    public List<Board> getBoardTest() {
        QBoard qBoard = QBoard.board;
        List<Board> list = queryFactory.selectFrom(qBoard)
                .where(qBoard.userid.eq("admin"),
                        qBoard.title.like("%test%")).fetch();

        return list;
    }

    @Override
    public void getBoardType(BoardType boardType) {
    }
}
