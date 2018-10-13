package book.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import book.member.dto.Book;

import static book.member.db.JdbcUtils.*;

public class BookDAO {
	Connection conn;
	
	public BookDAO() {
		conn=getConnection();
	}

//채형섭
	public ArrayList<Book> selectAllMember() {
		String sql = "select * from book";//테이블의 정보를  등록된 순서에 맞게 모든 정보를 가져 온다
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Book> list =null;
				
		
		try {
			
			list=new ArrayList<Book>();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Book b=new Book(rs.getString("name"),
						rs.getInt("cost"),
						rs.getInt("amount"),
						rs.getInt("sale"),
						rs.getInt("count"));
				list.add(b);
						
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn);
			close(pstmt);
			close(rs);
		}
			
		return list;
	}
	
	
	public ArrayList<Book> selecRecommend() {
		String sql = "select * from book order by count desc";//판매 수량을 기준으로 내림차 순정리
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<Book> list =null;
				
		
		try {
			list=new ArrayList<Book>();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Book b=new Book(rs.getString("name"),
						rs.getInt("cost"),
						rs.getInt("amount"),
						rs.getInt("sale"),
						rs.getInt("count"));
				list.add(b);
						
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(conn);
			close(pstmt);
			close(rs);
		}
			
		return list;
	}
	


//김현승
	
	public int inserBook(Book newBook) {

		String sql="insert into book values(?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt=null;
		int insertCount=0;
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, newBook.getName());
			pstmt.setInt(2, newBook.getCost());
			pstmt.setInt(3, newBook.getAmount());
			pstmt.setInt(4, newBook.getSale());
			pstmt.setInt(5, newBook.getCount());
			
			insertCount=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			close(pstmt);
			close(conn);
		}
		return insertCount;
		
	}
	


//	public Book selectOneBook(String name) {
//		String sql="select * from book where name=?";
//		PreparedStatement pstmt =null;
//		ResultSet rs=null;
//		Book oldbook = null;
//
//		try {
//			//Class.forName("oracle.jdbc.driver.OracleDriver");
//			pstmt=conn.prepareStatement(sql);
//			pstmt.setString(1, name);
//			
//			rs=pstmt.executeQuery();
//			if(rs.next()){
//				oldbook=new Book(rs.getString("name"),
//						rs.getInt("cost"),
//						rs.getInt("amount"),
//						rs.getInt("sale"),
//						rs.getInt("count"));
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			close(pstmt);
//			close(conn);
//			close(rs);
//		}
//
//		return oldbook;
//	}

	public int updateBook(String name, Book updateBook) {
		String sql="update book set sale=? where name=?";
		int check =0;
		
		PreparedStatement pstmt=null;
		
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1,updateBook.getSale());
			pstmt.setString(2, updateBook.getName());
			check=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			close(pstmt);
			close(conn);
		}

		return check;

	}
	
	
//김아영
	
	public ArrayList<Book> selectOnebook(String name) { // DB에서 책(1권) 정보 출력 메소드 _ name을 넘겨받음

		String sql = "select * from book where name like '%"+name+"%'"; // 이름이 name과 같은 책의 모든 정보를 선택
		
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Book> list = new ArrayList<Book>();
		boolean isStop = false;
		Book book = null;
	
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); //result set으로 결과값을 받아옴
			do {if (rs.next()) { // 받아온 결과값이 존재한다면, 정보를 book 객체로 생성
				list.add(new Book(rs.getString("name"), 
						rs.getInt("cost"), 
						rs.getInt("amount"), 
						rs.getInt("sale"),
						rs.getInt("count")));
			}else {isStop = true;}
			}while(!isStop);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn);
			close(pstmt);
			close(rs);
		}
		return list;
	}

	public int buyBook(ArrayList<Book> buyList) { // 책 구매 결과를 DB에 반영하는 메서드 _ collection을 받아옴
		int updateCount = 0;
		PreparedStatement pstmt = null;
		for(int i = 0; i<buyList.size(); i++) { // collection으로 받아왔기 때문에, 받아온 collection의 사이즈 만큼 DB반영을 반복해야한다.
			String sql = "update book set amount = ?, count = ? where name = ?"; // 변경 변수 - amount, count only. name이 같은 것의 해당 값을 변경
			Book book = buyList.get(i);
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, book.getAmount());
				pstmt.setInt(2, book.getCount());
				pstmt.setString(3, book.getName());
				updateCount = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		close(conn);
		close(pstmt);
		return updateCount;
	}

	public ArrayList<Book> saleBook() {
		ArrayList<Book> list = null;
		String sql = "select * from book where sale <> 0";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			list = new ArrayList<Book>();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Book book = new Book(rs.getString("name"),
									rs.getInt("cost"),
									rs.getInt("amount"),
									rs.getInt("sale"),
									rs.getInt("count"));
				list.add(book);
			}			
		}catch(SQLException e) {e.printStackTrace();
		}finally {
			close(conn);
			close(pstmt);
			close(rs);
		}
		return list;
	}
	
//김종호
	public Book searchbook(String name) {
		String sql = "select * from book where name = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Book book = null;
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				book = new Book(rs.getString("name"),
								 rs.getInt("cost"),
								 rs.getInt("amount"),
								 rs.getInt("sale"),
								 rs.getInt("count"));
				}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
			close(conn);
		}
		return book;
	}
	
	public int Enterbook(Book book) {
		String sql = "UPDATE book set amount = ? where name = ?";
		int check = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, book.getAmount());
			pstmt.setString(2,book.getName());
			
			check = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
				
		return check;	
	}
	
	
//이승환
	public int removeBook(Book book) {
		String sql = "delete from book where name = ?";
		int check = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,book.getName());
			
			check = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
				
		return check;	
	}

	/**
	 * �솚遺�
	 * @param dto
	 * @return
	 */
	public int RefundBook(Book book) {
		String sql = "UPDATE book set amount = ?, count = ? where name = ?";
		int check = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, book.getAmount());
			pstmt.setInt(2, book.getCount());
			pstmt.setString(3,book.getName());
			
			check = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
				
		return check;
	}
	
	
	/**
	 * �솚遺�
	 * @param dto
	 * @return
	 */
	public void updateRefundBook(Book dto) {
		
		String sql = "UPDATE BOOK SET AMOUNT = ?, COUNT  = ? WHERE NAME   = ?";

		int amount = dto.getAmount();
		int count = dto.getCount();
		String bookNm = dto.getName();
		
		PreparedStatement pstmt = null;
		
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, amount);	//첫번째 물음표
			pstmt.setInt(2, count);	
			pstmt.setString(3, bookNm);		
			
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}				
		return;
	}
	
	
}
