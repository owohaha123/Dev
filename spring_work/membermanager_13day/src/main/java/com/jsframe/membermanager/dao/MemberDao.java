package com.jsframe.membermanager.dao;

import com.jsframe.membermanager.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
    void insertMember(MemberDto member);
    String selectPwd(String mid);
    MemberDto selectMember(String mid);
    void updateMember(MemberDto member);
    void deleteMember(String mid);
}
