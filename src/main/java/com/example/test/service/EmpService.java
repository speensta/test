package com.example.test.service;

import com.example.test.vo.Board;
import com.example.test.vo.Emp;
import com.example.test.vo.EmpVO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmpService {

    List<EmpVO> getEmpList();
}
