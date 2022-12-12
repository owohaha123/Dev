package com.jsframe.bserver.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "board")
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bnum;

    @Column(nullable = false, length = 45)
    private String btitle;

    @Column(nullable = false)
    private String bmid;

    @Column(nullable = false)
    private String bcontent;

    @CreationTimestamp
    @Column
    private Timestamp rdate;

    @Transient
    private List<BoardFile> bfList;
}
