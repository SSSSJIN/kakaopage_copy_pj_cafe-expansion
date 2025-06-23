

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUserCheck {

	public static void main(String[] args) {
		// ✅ 너의 app-context.xml DB 설정과 동일하게 맞춰줘
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "hr"; // 또는 ebook 등
		String password = "hr";

		try {
			// 드라이버 로드 (Oracle JDBC 사용 시)
			Class.forName("oracle.jdbc.OracleDriver");

			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement stmt = conn.prepareStatement("SELECT user FROM dual");
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				System.out.println("✅ 현재 접속한 DB 계정: " + rs.getString(1));
			}

			rs.close();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			System.out.println("❌ DB 연결 실패 또는 쿼리 오류");
			e.printStackTrace();
		}
	}
}
