package com.jsframe.jspboard.dto;

import lombok.Data;

@Data
public class MemberDto {
	private String m_id;
	private String m_pwd;
	private String m_name;
	private String m_birth;
	private String m_addr;
	private String m_phone;
	private int m_point;
	private String g_name;
}
//member 테이블, minfo 뷰 공용.