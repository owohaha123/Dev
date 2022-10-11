package com.dto;

import lombok.Getter;
import lombok.Setter;

@Getter // getter 메소드 자동 생성
@Setter // setter 메소드 자동 생성
public class MemberDto { // dto = Vo(Value Object)
    private String m_id;
    private String m_pwd;
    private String m_name;
    private String m_phone;
    private String m_birth;


//    @Override
//    public String toString() {
//        String str = "CODE : " + m_code + "\n"
//                    + "STR : " + m_str + "\n"
//                    + "INT : " + m_int + "\n"
//                    + "DATE : " + m_date;
//        return str;
//    } // 데이터의 출력 형식을 지정
}
