package com.jsframe.membermanager.dao;

import com.jsframe.membermanager.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberDao {
    void insertMember(MemberDto member);
}
