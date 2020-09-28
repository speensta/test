package com.example.test.service.impl;

import com.example.test.vo.Board;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

public interface BoardCrudRepository extends CrudRepository<Board, Long> {

    @Modifying
    @Transactional
    @Query(value = "update Board a set a.hit = a.hit+1 where a.id = :id")
    void updateHit(@Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "update Board a set a.title = :#{#board.title}, a.regnm = :#{#board.regnm}, a.content = :#{#board.content} where a.id = :id")
    void update(@Param("board") Board board);


    @Query(value = "select title, regnm, userid from Board where userid = :#{#board.userid}")
    List<Board> findAllByUserId(Board board);


}
