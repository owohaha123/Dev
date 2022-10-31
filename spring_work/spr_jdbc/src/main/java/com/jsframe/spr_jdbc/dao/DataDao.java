package com.jsframe.spr_jdbc.dao;

import com.jsframe.spr_jdbc.dto.DataDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DataDao {
    public int getCount();
    int insertData(DataDto data);
    List<DataDto> selectList();
}
