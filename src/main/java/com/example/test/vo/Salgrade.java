package com.example.test.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salgrade {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer grade;
    @Column
    private Integer losal;
    @Column
    private Integer hisal;


    
}
