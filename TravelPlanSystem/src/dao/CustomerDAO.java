package dao;

import static db.JdbcUtils.close;
import static db.JdbcUtils.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Customer;

public class CustomerDAO {
	
	private Connection conn = null;
	
	public CustomerDAO() {
		try {
			this.conn = getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Customer loginCheck(String email, String pass) {
		String sql = "select * from customer where email = ? and pass = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Customer cs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, pass);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cs = new Customer(rs.getString("email"),
									rs.getString("pass"),
									rs.getString("nickName"),
									rs.getString("authority"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return cs;
	}
	
	public void insertCustomer(Customer cs) {
		String sql = "insert into customer(email, pass, nickName) values(?, ?, ?)";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, cs.getEmail());
			pstmt.setString(2, cs.getPass());
			pstmt.setString(3, cs.getNickName());
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
	}
	
	public boolean emailCheck(String email) {
		String sql = "select email from customer where email = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return true;
	}
	
	public boolean nickNameCheck(String nickName) {
		String sql = "select email from customer where email = ?";

		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nickName);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return true;
	}
    //모든 회원정보를 가져오고
    //ArrayList<CustomerList> : 회원 List를 리턴해준다.
	public ArrayList<Customer> getMemberList() {
			
		ArrayList<Customer> CustomerList =new ArrayList<Customer>();
		String sql = "select * from customer";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CustomerList.add(new Customer(
						rs.getString("email"),
						rs.getString("pass"),
						rs.getString("nickName"),
						rs.getString("authority")));		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			close(conn);
		}

		return CustomerList;
	}
	
	public void deleteCustomer(String email) {
		String sql = "delete from customer where email = ?";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
	}
	
	public String findEmail(String email) {
		String sql = "select email from customer where nickName = ?";
		
		String email2 = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
		
			if(rs.next()) {
				email2 = rs.getString("email");
				return email2;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return email2;
	}
	
	public String findPass(String pass) {
		String sql = "select pass from customer where email =?";
		
		String password = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pass);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				password = rs.getString("pass");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return password;
	}
	
}
