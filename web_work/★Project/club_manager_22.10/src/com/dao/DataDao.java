package com.dao;

import com.dto.ClubDto;
import com.dto.MemberDto;

import java.sql.*;

public class DataDao {
    // DB 연동에 필요한 정보를 작성
    private String drv = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/clubdb";
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

    public MemberDto selectId(String id) {
        MemberDto data = null;

        String query = "SELECT * FROM membertbl WHERE m_id = ?";

        try {
            conn = DriverManager.getConnection(url,user,pass);

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if(rs.next()){
                data = new MemberDto();
                data.setM_id(rs.getString(1));
                data.setM_pwd(rs.getString(2));
                data.setM_name(rs.getString(3));
                data.setM_phone(rs.getString(4));
                data.setM_birth(rs.getString(5));
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            data = null;
        } finally {
            close();
        }

        return data;
    }

    public int insertClub(ClubDto data) {
        int result = 0; // 0이면 삽입 실패, 0이 아니면 성공

        String query = "INSERT INTO clubtbl VALUES (null,?,?)";
        try {
            conn = DriverManager.getConnection(url, user, pass);
            pstmt = conn.prepareStatement(query);
            // 쿼리문의 '?' 부분 채우기
            pstmt.setString(1, data.getCb_name());
            pstmt.setString(2, (data.getCb_content()));
            // 쿼리문 실행 및 실행 결과 받기
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            result = 0; // 삽입 실패
        }

        return result; // 실행 결과를 service 로 전달
    }

    public int insertUserToClub(String m_id, int club_no) {
        int result = 0; // 0이면 삽입 실패, 0이 아니면 성공

        String query = "INSERT INTO jointbl VALUES (?,?,DEFAULT)";
        try {
            conn = DriverManager.getConnection(url, user, pass);
            pstmt = conn.prepareStatement(query);
            // 쿼리문의 '?' 부분 채우기
            pstmt.setString(1, m_id);
            pstmt.setInt(2, club_no);
            // 쿼리문 실행 및 실행 결과 받기
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            result = 0; // 삽입 실패
        }

        return result; // 실행 결과를 service 로 전달
    }


    public int getClubByName(String cb_name) {
        int result = -1;

        String query = "SELECT cb_no FROM clubtbl WHERE cb_name = ?";

        try {
            conn = DriverManager.getConnection(url,user,pass);

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, cb_name);
            rs = pstmt.executeQuery();

            if(rs.next()){
                result = rs.getInt(1);
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            result = -1;
        } finally {
            close();
        }

        return result;
    }
}
