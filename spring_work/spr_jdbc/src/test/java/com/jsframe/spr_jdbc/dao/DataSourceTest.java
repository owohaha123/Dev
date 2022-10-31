package com.jsframe.spr_jdbc.dao;

import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class) // 관련있는 것끼리만 함께 실행
@SpringBootTest
@Log
public class DataSourceTest {
    @Autowired // 아래의 것(DataSource 인터페이스)을 자동 주입
    DataSource dataSource;

    @Test
    public void testConnection(){
        //MySQL(DB)와의 접속이 잘 되는지 테스트하는 메소드
        try(Connection conn = dataSource.getConnection()) {
            log.info("접속 성공");
        } catch (SQLException e) {
            log.info("접속 실패");
        }
    }
}
