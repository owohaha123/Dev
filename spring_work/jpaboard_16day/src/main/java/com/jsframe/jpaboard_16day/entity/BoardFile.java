package com.jsframe.jpaboard_16day.entity;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "boardfiletbl")
@Data
public class BoardFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bfnum;

    //외래키 설정(1 : 다 관계에 대해서..)
    @ManyToOne
    @JoinColumn(name = "bfbid")
    private Board bfbid;
    //관계를 수립할 테이블의 entity 클래스로 자료형을 설정.

    @Column(nullable = false, length = 50)
    private String bfsysname;

    @Column(nullable = false, length = 50)
    private String bforiname;
}
