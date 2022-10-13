package com.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JoinDto {
    private String jm_id;
    private int jcb_no;
    private String j_date;

    @Override
    public String toString() {
        String str = "가입한 회원의 ID : " + jm_id + "\n"
                + "가입한 동호회의 번호 : " + jcb_no + "\n"
                + "동호회 가입한 날짜 : " + j_date + "\n";
        return str;
    }
}
