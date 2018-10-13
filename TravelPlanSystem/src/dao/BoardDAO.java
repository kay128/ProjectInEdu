package dao;

import static db.JdbcUtils.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Board;


public class BoardDAO {
private Connection conn = null;
	
	public BoardDAO() {
		try {
			this.conn = getConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Board> getboardlist() {
		// TODO Auto-generated method stub
		String sql = "select * from board ORDER BY boardGroup DESC, boardSequence ASC";
		ArrayList<Board> list = new ArrayList<Board>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){	
				list.add(new Board(
						rs.getInt("boardId"),
						rs.getString("userEmail"),
						rs.getString("boardTitle"),
						rs.getString("boardContent"),
						rs.getString("boardDate"),	
						rs.getInt("boardHit"),
						rs.getInt("boardGroup"),
						rs.getInt("boardSequence"),
						rs.getInt("boardLevel"),
						rs.getInt("boardAvailable")));
			};
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			close(pstmt);
			close(rs);
			close(conn);
			
			
		}
		System.out.println("boardlistaction");
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getboardTitle());
		}
		return list;
	}
	
	public int insertBoard(Board newBoard) {
		String sql = "insert into board values(boardId_seq.nextval, ?, ?, ?, ?, ?,boardGroupId_seq.nextval,0,0,0)";
		PreparedStatement pstmt = null;
		int insertResult=0;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, newBoard.getuserEmail());
			pstmt.setString(2, newBoard.getboardTitle());
			pstmt.setString(3, newBoard.getboardContent());
			pstmt.setString(4, newBoard.getboardDate());
			pstmt.setInt(5, newBoard.getboardHit());
			insertResult = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}finally{
		 close(pstmt);
		 close(conn);
		}
		return insertResult;
	}

	public Board getboardById(int boardId) {
		String sql1 = "update board set boardHit = boardHit+1 where boardId=?";
		String sql2 = "select * from board where boardId=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board board = null; 
		int insertResult=0;
		try {
			pstmt=conn.prepareStatement(sql1);
			pstmt.setInt(1, boardId);
			pstmt.executeUpdate();
			
			pstmt=conn.prepareStatement(sql2);
			pstmt.setInt(1, boardId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board = new Board(
					rs.getInt("boardId"),
					rs.getString("userEmail"),
					rs.getString("boardTitle"),
					rs.getString("boardContent"),
					rs.getString("boardDate"),	
					rs.getInt("boardHit"),
					rs.getInt("boardGroup"),
					rs.getInt("boardSequence"),
					rs.getInt("boardLevel"),
					rs.getInt("boardAvailable"));
			}

		} catch(Exception e) {
			e.printStackTrace();
		}finally{
		 close(pstmt);
		 close(rs);
		 close(conn);
		}
		
		System.out.println(board.getboardContent());
		System.out.println("boardDate"+board.getboardDate());
		System.out.println("boardHit"+ board.getboardHit());
		return board;	
	}

	public int getUpdateHit(int boardId) {
		String sql = "update board set boardHit = boardHit+1 where boardId=?";
		
		PreparedStatement pstmt=null;
		
		int updateResult=0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,boardId);
			
			updateResult = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
			close(conn);
		}
		
		return updateResult;
		
	}

	public int modifyBoard(Board board) {

		String sql = "update board set boardTitle=?, boardContent=?, boardDate=? where boardId=?";
		PreparedStatement pstmt = null;
		int modifyResult=0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getboardTitle());
			pstmt.setString(2, board.getboardContent());
			pstmt.setString(3, board.getboardDate());
			pstmt.setInt(4, board.getboardId());
			modifyResult = pstmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
		
		return modifyResult;
		
	}
	public int deleteBoardbyId(int boardId, String boardDate) {
		String sql = "update board set boardTitle='削除されたポスティングです', boardContent='削除されたポスティングです', boardDate=?, boardAvailable=1 where boardId=?";
		PreparedStatement pstmt = null;
		
		int deleteResult = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,boardDate);
			pstmt.setInt(2, boardId);
			deleteResult = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
		
		return deleteResult;
		
	}
	
	/*
	 * 	private int boardId;
	private String userEmail;
	private String boardTitle;
	private String boardContent;
	private String boardDate;
	private int boardHit;
	private int boardGroup;
	private int boardSequence;
	private int boardLevel;
	private int boardAvailable;
	 */

	public int replyBoard(Board board, Board parentBoard) {
		String sql = "insert into board values(boardId_seq.nextval, ?, ?, ?, ?, ?,?,?,?,?)";
		
		PreparedStatement pstmt = null;
		
		int insertResult = 0;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, );
			pstmt.setString(1, board.getuserEmail());
			pstmt.setString(2, board.getboardTitle());
			pstmt.setString(3, board.getboardContent());
			pstmt.setString(4, board.getboardDate());
			pstmt.setInt(5, board.getboardHit());
			pstmt.setInt(6, parentBoard.getBoardGroup());
			pstmt.setInt(7, parentBoard.getBoardSequence()+1);
			pstmt.setInt(8, parentBoard.getBoardLevel()+1);
			pstmt.setInt(9, 0);
			
			insertResult = pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}finally{
			close(pstmt);
			close(conn);
		}
		
		return insertResult;
		
	}
}
