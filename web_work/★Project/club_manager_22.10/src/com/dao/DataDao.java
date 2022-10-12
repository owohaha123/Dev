package com.dao;

import com.dto.ClubDto;
import com.dto.JoinDto;
import com.dto.MemberDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataDao {
    // DB 연동에 필요한 정보를 작성
    private String drv = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/clubdb";
    private String user = "dev01";
    private String pass = "12341234";

    // DB 연동관련 객체
    private Connection conn; // DB 연동
    private PreparedStatement pstmt; // SQL 을 전달하는 매개체
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

    // ---------------------------------------------------------------------------동수-----------------------
    public int insertClub2(JoinDto data) {
        int result = 0; // 0이면 삽입실패, 0이 아니면 성공

        String query = "INSERT INTO jointbl VALUES "
                + "(?,?,?)";

        try {
            conn = DriverManager.getConnection(url, user, pass);
            pstmt = conn.prepareStatement(query);
            // 쿼리문의 '?'부분 채우기
            pstmt.setString(1, data.getJm_id());
            pstmt.setInt(2, data.getJcb_no());
            pstmt.setString(3, data.getJ_date());
            // 쿼리문 실행 및 실행 결과 받기
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            result = 0; // 삽입 실패
        } finally {
            close();
        }

        return result; // 실행 결과를 service에 전달
    }

    public int insertClub3(JoinDto data) {
        int result = 0; // 0이면 삽입실패, 0이 아니면 성공

        String query = "INSERT INTO jointbl VALUES "
                + "(?,?,?)";

        try {
            conn = DriverManager.getConnection(url, user, pass);
            pstmt = conn.prepareStatement(query);
            // 쿼리문의 '?'부분 채우기
            pstmt.setString(1, data.getJm_id());
            pstmt.setInt(2, data.getJcb_no());
            pstmt.setString(3, data.getJ_date());
            // 쿼리문 실행 및 실행 결과 받기
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            result = 0; // 삽입 실패
        } finally {
            close();
        }

        return result;
    }

    public int insertClub4(JoinDto data) {
        int result = 0; // 0이면 삽입실패, 0이 아니면 성공

        String query = "INSERT INTO jointbl VALUES "
                + "(?,?,?)";

        try {
            conn = DriverManager.getConnection(url, user, pass);
            pstmt = conn.prepareStatement(query);
            // 쿼리문의 '?'부분 채우기
            pstmt.setString(1, data.getJm_id());
            pstmt.setInt(2, data.getJcb_no());
            pstmt.setString(3, data.getJ_date());
            // 쿼리문 실행 및 실행 결과 받기
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            result = 0; // 삽입 실패
        } finally {
            close();
        }

        return result;
    }
    public List<ClubDto> selectClubList() { // case 3 method
        List<ClubDto> cList = null;

        String query = "SELECT * FROM clubtbl";

        try {
            conn = DriverManager.getConnection(url, user, pass);
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            // 처리할(가져올) 행이 없으면 rs.next()는 false를 반환.
            while (rs.next()){
                if (cList == null){ // 목록이 없을 때만 목록을 생성.
                    cList = new ArrayList<>();
                }

                // DTO를 목록 추가.
                ClubDto data = new ClubDto();
                data.setCb_no(rs.getInt(1));
                data.setCb_name(rs.getString(2));
                data.setCb_content(rs.getString(3));

                cList.add(data);
            }
        } catch (SQLException e) {
            cList = null;
        } finally {
            close();
        }

        // service로 목록 전달(데이터가 없을 경우 null 전달)
        return cList;
    }

    public List<JoinDto> selectMemberList() { // case 4 method
        List<JoinDto> jList = null;

        String query = "SELECT * FROM jointbl";

        try {
            conn = DriverManager.getConnection(url, user, pass);
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            // 처리할(가져올) 행이 없으면 rs.next()는 false를 반환.
            while (rs.next()){
                if (jList == null){ // 목록이 없을 때만 목록을 생성.
                    jList = new ArrayList<>();
                }

                // DTO를 목록 추가.
                JoinDto data = new JoinDto();
                data.setJm_id(rs.getString(1));
                data.setJcb_no(rs.getInt(2));
                data.setJ_date(rs.getString(3));

                jList.add(data);
            }
        } catch (SQLException e) {
            jList = null;
        } finally {
            close();
        }

        // service로 목록 전달(데이터가 없을 경우 null 전달)
        return jList;
    }

    // ---------------------------------------------------------------------------윤주-----------------------
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
        // cb_no 와 겹치지 않도록 -1 설정
        int result = -1;

        // DB 에서 실행하고자 하는 쿼리
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

    public List<ClubDto> selectData(String m_id) {
        List<ClubDto> list = null;

        String query = "SELECT C.cb_no, C.cb_name FROM jointbl J JOIN clubtbl C ON J.jcb_no = C.cb_no WHERE J.jm_id = ?";

        try {
            conn = DriverManager.getConnection(url,user,pass);

            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, m_id);
            rs = pstmt.executeQuery();

            while(rs.next()){
                if(list == null){ // 목록이 없을 때만 목록을 생성
                    list = new ArrayList<>();
                }
                ClubDto data = new ClubDto();
                data.setCb_no(rs.getInt(1));
                data.setCb_name(rs.getString(2));

                list.add(data);
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            list = null;
        } finally {
            close();
        }

        return list;
    }

    public int deleteData(ClubDto data, String id) {
        int result = 0;

        String query = "DELETE FROM jointbl WHERE jcb_no = ? and m_id = ?";

        try {
            conn = DriverManager.getConnection(url, user, pass);
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, data.getCb_no());
            pstmt.setString(2, id);

            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            //e.printStackTrace();
            result = 0;
        }finally {
            close();
        }

        return result;
    }
}
