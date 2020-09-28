package com.example.test.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer empno;
    @Column
    private String ename;
    @Column
    private String job;
    @Column
    private Integer mgr;
    @CreationTimestamp
    @ColumnDefault("CURRENT_TIMESTAMP")
    private LocalDateTime hiredate;
    @Column
    private Integer sal;
    @Column
    private Integer comm;
    @Column
    private Integer deptno;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "deptno", insertable = false, updatable = false)
    private Dept dept;

}
