package com.jsframe.spr_jdbc.dao;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
public class DaoTest {
    @Autowired
    DataDao dDao;

    @Test
    public void getCountTest(){
        try{
            int n = dDao.getCount();
            log.info("갯수 : " + n);
        }catch (Exception e){
            log.info("처리 실패");
        }
    }
}
