package com.example.test.service.impl;

import com.example.test.vo.Board;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface BoardCrudRepository extends CrudRepository<Board, Long> {
    @Modifying
    @Transactional
    @Query(value = "update Board a set a.hit = 1 where a.id = :id")
    void updateHit(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "update Board a set a.title = :#{#board.title}, a.regnm = :#{#board.regnm}, a.content = :#{#board.content} where a.id = :id")
    void update(@Param("board") Board board);
}
