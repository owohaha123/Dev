package com.jsframe.spr_jdbc2_12day.dao;

import com.jsframe.spr_jdbc2_12day.dto.DataDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DataDao {
    void insertData(DataDto data);
    List<DataDto> selectList();
    // 하나의 정보를 가져오는 메소드
    DataDto selectData(int code);
    // 데이터 수정용 메소드
    void updateData(DataDto data);
    // 데이터 삭제용 메소드
    void deleteData(int code);
}
