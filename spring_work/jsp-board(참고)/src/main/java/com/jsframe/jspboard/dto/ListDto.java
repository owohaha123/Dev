package com.jsframe.jspboard.dto;

import lombok.Data;

@Data
public class ListDto {
	private String colname;//b_title, b_contents 중 하나 저장.
	private String keyword;//검색단어.
	private int pageNum;
	private int listCnt;
}
