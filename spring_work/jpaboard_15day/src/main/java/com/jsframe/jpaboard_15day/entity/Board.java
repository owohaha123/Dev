package com.jsframe.jpaboard_15day.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "boardtbl")
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // strategy = autoincrement
    private long bnum;

    @Column(nullable = false, length = 45)
    private String btitle;

    @Column(nullable = false, length = 20)
    private String bwriter;

    @Column(nullable = false, length = 20)
    private String bpwd;

    @Column(nullable = false)
    private String bcontent;

    @CreationTimestamp
    @Column
    private Timestamp rdate;
}
