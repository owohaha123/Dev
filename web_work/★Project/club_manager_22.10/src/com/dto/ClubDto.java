package com.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClubDto {
    private int cb_no;
    private String cb_name;
    private String cb_content;

    @Override
    public String toString() {
        return "이름 " + cb_name ;
    }

    public String toString2(){
        String str = "동호회 번호 : " + cb_no + "\n"
                + "동호회 이름 : " + cb_name + "\n"
                + "동호회 소개 : " + cb_content + "\n";
        return str;
    }
}
