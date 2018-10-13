package lab27.db;

/** 
 * DB 연동과 관련된 공통된 작업을 구현하는 클래스 : java.sql.*
 * step1. 드라이버 로딩
 * step2. Connection 객체 생성
 * step3. 자원(Resource)을 닫는 작업(close)
 *        - Connection, Statement(정적쿼리), PreparedStatement(동적쿼리), ResultSet
 *        - CRUD(DML : select, insert, update, delete)
 * step4. 트랜잭션 관련 - commit, rollback
 * */
import java.sql.*;

public class JdbcUtils {

	/** 
	 * 드라이버 로딩
	 * */
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			e.printStackTrace();
		}
	}
	
	/** 
	 * Connection 객체 생성
	 * @return Connection
	 * */	
	public static Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "jsl27_community";
		String password = "1234";
		
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
				
		return conn;
	}
	
	/**
	 * 자원을 닫는 작업 : 오버로딩(Overloading)
	 * @param conn
	 * @param pstmt
	 * @param rs
	 */
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/** 
	 * 트랜잭션 관련 작업 
	 * @param conn
	 */
	public static void commit(Connection conn) {
		try {
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
