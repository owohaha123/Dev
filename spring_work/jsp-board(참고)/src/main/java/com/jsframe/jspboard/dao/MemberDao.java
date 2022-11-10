package com.jsframe.jspboard.dao;

import com.jsframe.jspboard.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
	//비밀번호 구하기
	public String pwdSelect(String id);
	//회원 정보 구하기
	public MemberDto memberSelect(String id);
	//아이디 체크 메소드
	public int idCheck(String id);
	//회원 가입
	public void memberInsert(MemberDto member);

	public void memberPtUpdate(MemberDto member);
}
