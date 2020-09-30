package com.example.test.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dept {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer deptno;
    @Column
    private String dname;
    @Column
    private String loc;

    @OneToMany(mappedBy = "dept", fetch = FetchType.EAGER)
    private List<Emp> emps;

    
}
