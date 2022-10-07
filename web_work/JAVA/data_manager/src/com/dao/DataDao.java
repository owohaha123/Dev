package com.dao;

import com.dto.DataDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataDao {
    // DB 연동에 필요한 정보를 작성
    private String drv = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/datadb";
    private String user = "dev01";
    private String pass = "12341234";

    // DB 연동관련 객체
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    // 드라이버 로드 (생성자로 처리)
    public DataDao(){
        try {
            Class.forName(drv);
        } catch (ClassNotFoundException e) {}
    } // 생성자 end

    // 메모리 해제 메소드(각 DB 처리 메소드의 finally 부분에서 사용)
    private void close(){
        try {
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();
            if(conn != null) conn.close();
        } catch (SQLException e) {}
    }

    public int insertData(DataDto data) {
        int result = 0; // 0이면 삽입 실패, 0이 아니면 성공

        String query = "INSERT INTO datatbl VALUES (null,?,?,?)";

        try {
            conn = DriverManager.getConnection(url, user, pass);
            pstmt = conn.prepareStatement(query);
            // 쿼리문의 '?' 부분 채우기
            pstmt.setString(1, data.getM_str());
            pstmt.setInt(2, data.getM_int());
            pstmt.setDate(3, Date.valueOf(data.getM_date()));
            // 쿼리문 실행 및 실행 결과 받기
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            result = 0; // 삽입 실패
        }

        return result; // 실행 결과를 service 로 전달
    }

    public List<DataDto> selectList() {
        List<DataDto> dList = null;

        String query = "SELECT * FROM datatbl";

        try {
            conn = DriverManager.getConnection(url, user, pass);
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            // 처리할(가져올) 행이 없으면 rs.next()는 false 를 반환
            while (rs.next()){
                if(dList == null){ // 목록이 없을 때만 목록을 생성
                    dList = new ArrayList<>();
                }

                // DTO 를 목록 추가
                DataDto data = new DataDto();
                data.setM_code(rs.getInt(1));
                data.setM_str(rs.getString(2));
                data.setM_int(rs.getInt(3));
                data.setM_date(rs.getString(4));

                dList.add(data);
            }
        } catch (SQLException e) {
            dList = null;
        }finally {
            close();
        }

        // service 로 목록 전달 (데이터가 없을 경우 null 전달)
        return dList;
    }
}
