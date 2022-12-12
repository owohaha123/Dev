package com.jsframe.bserver.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "boardfiletbl")
@Data
public class BoardFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bfnum;


    @Column(name = "bfbid")
    private long bfbid;
    //관계를 수립할 테이블의 entity 클래스로 자료형을 설정.

    @Column(nullable = false, length = 50)
    private String bfsysname;

    @Column(nullable = false, length = 50)
    private String bforiname;
}
