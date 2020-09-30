package com.example.test;

import com.example.test.service.impl.BoardRepository;
import com.example.test.service.impl.MemberRepository;
import com.example.test.vo.Board;
import com.example.test.vo.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@SpringBootTest
class TestApplicationTests {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    private JPAQueryFactory queryFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
//    @Rollback(false)
//    @Transactional
    void contextLoads() {
        Member member = new Member();
        member.setUserid("admin25");
        member.setRegnm("테스트14");
        member.setRole("test");

        memberRepository.save(member);
//        entityManager.persist(member);

        Board board = new Board();
        board.setId(180L);
        board.setTitle("2동해물과");
        board.setContent("2동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라만세 무궁화 삼천리 화려강산 대한사람 대한으로 길이 보전하세");
        board.setRegnm("테스트11");
        board.setUserid("admin25");

//        board.setMember(member);
        member.add(board);

//        entityManager.persist(board);
//        entityManager.clear();

        Board board2 = boardRepository.save(board);

//        System.out.println("==============================="+board2);

       //em.find();    // 엔티티 조회
       //em.persist(); // 엔티티 저장
       //em.remove();  // 엔티티 삭제
       //em.flush();   // 영속성 컨텍스트 내용을 데이터베이스에 반영
       //em.detach();  // 엔티티를 준영속 상태로 전환
       //em.merge();   // 준영속 상태의 엔티티를 영속상태로 변경
       //em.clear();   // 영속성 컨텍스트 초기화
       //em.close();   // 영속성 컨텍스트 종료



    }

}
