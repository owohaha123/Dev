package com.dto;

import lombok.Getter;
import lombok.Setter;

@Getter // getter 메소드 자동 생성
@Setter // setter 메소드 자동 생성
public class DataDto { // dto = Vo(Value Object)
    private int m_code;
    private String m_str;
    private int m_int;
    private String m_date;

    @Override
    public String toString() {
        String str = "CODE : " + m_code + "\n"
                    + "STR : " + m_str + "\n"
                    + "INT : " + m_int + "\n"
                    + "DATE : " + m_date;
        return str;
    } // 데이터의 출력 형식을 지정
}
