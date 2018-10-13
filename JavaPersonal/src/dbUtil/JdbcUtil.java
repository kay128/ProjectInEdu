package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("DataBase 연결에 오류가 발생하였습니다.");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		final String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		final String user = "jsl27";
		final String password = "1234";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("DataBase 연결에 오류가 발생하였습니다.");
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			conn.close();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("DataBase 연결 종료에서 오류가 발생하였습니다.");
			e.printStackTrace();
		}
		
	}
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			conn.close();
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("DataBase 연결 종료에서 오류가 발생하였습니다.");
			e.printStackTrace();
		}
		
	}
}
