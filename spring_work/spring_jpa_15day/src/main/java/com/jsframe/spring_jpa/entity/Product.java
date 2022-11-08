package com.jsframe.spring_jpa.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "producttbl")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //자동생성
    private long pnum;

    @Column(nullable = false, length = 45)
    private String pname;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int amount;

    @Column
    @CreationTimestamp
    private Timestamp rdate;

}
