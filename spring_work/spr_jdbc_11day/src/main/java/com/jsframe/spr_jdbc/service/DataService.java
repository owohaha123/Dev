package com.jsframe.spr_jdbc.service;

import com.jsframe.spr_jdbc.dao.DataDao;
import com.jsframe.spr_jdbc.dto.DataDto;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
@Log
public class DataService {
    // DB 와 연계된 작업을 수행 -> Dao 클래스를 사용
    @Autowired
    private DataDao dDao;

    public String inputData(DataDto data) {
        String msg = null;
        int result = 0;

        result = dDao.insertData(data);

        return msg;
    }

    //데이터 목록 받는 메소드
    public ModelAndView outputList(){
        log.info("outputList()");
        ModelAndView mv = new ModelAndView();
        List<DataDto> dList = dDao.selectList();
        mv.addObject("dList" , dList);
        mv.setViewName("dataList");

        return mv;
    }
}// class end
