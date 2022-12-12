package com.jsframe.bserver.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member")
@Data
public class Member {
    @Id
    private String mid;

    @Column(nullable = false, length = 100)
    private String mpwd;

    @Column(nullable = false, length = 20)
    private String mname;

    @Column(nullable = false, length = 20)
    private String mphone;
}
