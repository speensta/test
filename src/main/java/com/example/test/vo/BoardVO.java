package com.example.test.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BoardVO {

    private Long id;
    private String title;
    private String content;
    private String regnm;
    private String userid;
    private int hit;
    private LocalDateTime regdate;
    private LocalDateTime moddate;

}
