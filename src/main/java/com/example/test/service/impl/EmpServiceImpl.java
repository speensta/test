package com.example.test.service.impl;

import com.example.test.service.EmpService;
import com.example.test.vo.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private JPAQueryFactory queryFactory;

    @Override
    public List<EmpVO> getEmpList() {

        QEmp qEmp = QEmp.emp;
        QDept qDept = QDept.dept;
        QSalgrade qSalgrade = QSalgrade.salgrade;
        List<Emp> list = queryFactory.selectFrom(qEmp).leftJoin(qEmp.dept, qDept.dept)
                .fetchJoin().fetch();

        ModelMapper modelMapper = new ModelMapper();
        return list.stream()
                .map(q ->  modelMapper.map(q, EmpVO.class))
                .collect(Collectors.toList());
    }

}
