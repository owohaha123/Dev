package com.jsframe.spr_jdbc2_12day.dto;

import lombok.Data;

@Data
public class DataDto {
    // 필드(맴버변수)의 이름은 컬럼명과 동일하게, 반드시 소문자로!
    private int m_code;
    private String m_str;
    private int m_int;
    private String m_date;
}
