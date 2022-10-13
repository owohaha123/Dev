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


    @Override
    public String toString() {
        String str = "ID : " + m_id + "\n"
                + "PWD : " + m_pwd + "\n"
                + "NAME : " + m_name + "\n"
                + "PHONE : " + m_phone + "\n"
                + "BIRTH : " + m_birth + "\n";
        return str;
    } // 데이터의 출력 형식을 지정
}
