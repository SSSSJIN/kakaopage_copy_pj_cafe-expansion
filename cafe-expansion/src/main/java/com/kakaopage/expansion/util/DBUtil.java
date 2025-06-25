package com.kakaopage.expansion.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * DBUtil: 드라이버 로드, Connection 취득, 자원 해제 유틸리티
 */
public class DBUtil {

    // 드라이버 로드: 클래스 로딩 시 한 번만 수행
    static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); // Oracle 드라이버
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Oracle JDBC Driver 로드 실패", e);
        }
    }

    /** DB 연결 얻기 */
    public static Connection getConnection() throws SQLException {
        // URL, 계정·비번은 환경에 맞게 조정하세요.
        String url      = "jdbc:oracle:thin:@localhost:1521:xe";
        String username = "hr";
        String password = "hr";
        return DriverManager.getConnection(url, username, password);
    }

    /** ResultSet, PreparedStatement, Connection 순으로 닫기 */
    public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
        try { if (rs    != null && !rs.isClosed())    rs.close();    } catch (SQLException e) { /* ignore */ }
        try { if (pstmt != null && !pstmt.isClosed()) pstmt.close(); } catch (SQLException e) { /* ignore */ }
        try { if (conn  != null && !conn.isClosed())  conn.close();  } catch (SQLException e) { /* ignore */ }
    }

    /** PreparedStatement, Connection 닫기 */
    public static void close(PreparedStatement pstmt, Connection conn) {
        close(null, pstmt, conn);
    }
}
