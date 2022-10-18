package com.jsframe.springjsp01.dto;

import lombok.Data;

@Data
public class MemberDto {
    private String id;
    private String pwd;
    private String name;
    private int age; // jsp 에서는 문자열이지만 spring 이 자동으로 정수변환
}
