package book.member.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection conn=null;
		
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String user="jsl27";
		String password="1234";
		
		try{
			conn=DriverManager.getConnection(url, user, password);
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void close(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt){
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void close(PreparedStatement pstmt){
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs){
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
