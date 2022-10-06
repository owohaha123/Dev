package com.dao;

import com.dto.DataDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataDao {
    // DB 접속을 위한 사전 준비
    private String drv = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/datadb";
    private String user = "dev01";
    private String pass = "12341234";

    // DB 관련 객체
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    // 드라이버 로드(생성자)
    public DataDao() {
        try {
            Class.forName(drv); // driver class load
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버 로드 실패");
        }
    }//

    private void close(){
        try {
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();
            if(conn != null) conn.close();
        } catch (SQLException e) {
            // 비워도 무방
        }
    }// close end

    // 기능별 CRUD 메소드 작성
    public int insertData(DataDto data){
        int result = 0; // 0이 아니면 삽입성공, 0이면 삽입 실패

        String query = "INSERT INTO datatbl VALUES (null, ?,?,?)";

        try {
            conn = DriverManager.getConnection(url, user, pass);

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, data.getM_str());
            pstmt.setInt(2, data.getM_int());
            pstmt.setDate(3, Date.valueOf(data.getM_date()));

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            result = 0;
        }finally {
            close();
        }

        return result;
    }// insertData end

    // 테이블의 전체 목록을 가져오는 메소드
    public List<DataDto> selectList(){
        // DB 에서 테이블의 내용을 모두 가져와서 List(목록)에 저장
        // 저장할 목록 생성
        List<DataDto> dList = new ArrayList<>();

        // 전체 목록을 가져오는 쿼리 작성
        String query = "SELECT * FROM datatbl";

        try {
            conn = DriverManager.getConnection(url, user, pass);

            pstmt = conn.prepareStatement(query);

            rs = pstmt.executeQuery();

            // 여러 개의 결과값이 rs 에 포함되어 있음 -> 반복문으로 처리
            while(rs.next()){ // 값이 없으면 false 로 반복문 자동 중지
                // 행 단위로 처리 -> 한 DTO로
                DataDto data = new DataDto();

                data.setM_code(rs.getInt(1));
                data.setM_str(rs.getString(2));
                data.setM_int(rs.getInt(3));
                data.setM_date(rs.getString(4));

                dList.add(data); // 목록에 한 행 데이터 추가
            }
        } catch (SQLException e) {
            dList = null; // 문제 발생 시 목록을 비운다
        }finally {
            close();
        }

        return dList;
    }// selectList end

    public DataDto getData(int code){
        DataDto data = null;

        String query = "SELECT * FROM datatbl WHERE m_code = ?";

        try {
            conn = DriverManager.getConnection(url, user, pass);
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, code);

            rs = pstmt.executeQuery();

            if (rs.next()){
                data = new DataDto();
                data.setM_code(rs.getInt(1));
                data.setM_str(rs.getString(2));
                data.setM_int(rs.getInt(3));
                data.setM_date(rs.getString(4));
            }
        } catch (SQLException e) {
            data = null;
        }finally {
            close();
        }

        return data;
    }

    public int deleteData(int code) {
        int result = 0;

        String query = "DELETE FROM datatbl WHERE m_code = ?";

        try {
            conn = DriverManager.getConnection(url, user, pass);
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, code);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            result = 0;
        }

        return result;
    }
}// class end
