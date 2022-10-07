package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataDao {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // 1. 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 드라이버 매니저 : 외부 프로그램과 네트워크로 접속할 때
            //                 접속용 드라이버 라이브러리를 관리하는 객체
            System.out.println("드라이버 로드 성공");
            // 2. DB에 접속 : 접속 관리 객체 Connection
            conn = DriverManager.getConnection( // sql 커넥션 주소 및 계정
                    "jdbc:mysql://localhost:3306/devdb",
                    "dev01", "12341234"
            );
            System.out.println("접속 성공");
            }catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("드라이버 로드 실패");
            } catch (SQLException se) {
                se.printStackTrace();
                System.out.println("접속 실패");
            } finally {
                // 통로를 해제하는 작업
            try {
                System.out.println("접속 해제 성공");
                conn.close();
            } catch (SQLException e) {
                // 이곳엔 아무것도 작성하지 않는다
            }
            }
    }
}
