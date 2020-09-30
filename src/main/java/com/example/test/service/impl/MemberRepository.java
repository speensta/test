package com.example.test.service.impl;

import com.example.test.vo.Board;
import com.example.test.vo.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {

}
