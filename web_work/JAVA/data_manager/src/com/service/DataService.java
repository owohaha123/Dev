package com.service;

import com.dao.DataDao;
import com.dto.DataDto;

import java.util.List;

public class DataService {
    // dao 를 사용하여 DB 에 data 를 저장하고 결과를 controller 에게 알림
    private DataDao dDao = new DataDao();

    public String insertData(DataDto data) {
        String msg = null;

        // Dao 를 사용하여 저장
        int res = dDao.insertData(data);

        if(res == 0){
            msg = "Insert Failed";
        }else{
            msg = "Insert Success";
        }

        return msg;
    }

    public List<DataDto> getList() {
        // Dao 에게 DB 로부터 데이터를 검색하여 목록을 가져오게 시킴
        List<DataDto> gList = dDao.selectList();
        // 받은 목록을 controller 에게 전달
        return gList;
    }

    public DataDto getData(int code) {
        DataDto data = null;
        //전달 받은 검색값을 사용하여 DB select 작업을 수행 -> Dao
        data = dDao.selectData(code);
        //검색 결과 데이터를 controller  에 전달(반환)
        return data;
    }

    public String updateData(DataDto data) {
        String msg = null;

        //dao에서 DB 수정처리.
        int res = dDao.updateData(data);

        if(res > 0){
            msg = "Update Success.";
        }
        else {
            msg = "Update Failed.";
        }

        return msg;
    }

    public String DeleteData(int code) {
        String msg = null;

        int res = dDao.deleteData(code);

        if(res > 0){
            msg = "Delete Success!";
        }else {
            msg = "Delete Failed.";
        }

        return msg;
    }
}


