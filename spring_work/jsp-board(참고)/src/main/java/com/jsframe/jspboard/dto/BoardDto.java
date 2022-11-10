package com.jsframe.jspboard.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardDto {//blist 뷰와 같은 이름을 사용
	private int b_num;
	private String b_title;
	private String b_contents;
	private String b_id;
	private String m_name;
	//DB의 datetime 타입과 연동이 잘되는 자료형
	private Timestamp b_date;
	private int b_views;
}
