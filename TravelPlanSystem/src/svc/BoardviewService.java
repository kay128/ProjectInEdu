package svc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.BoardDAO;
import model.Board;

public class BoardviewService {

	public ArrayList<Board> getboardlist() {
		ArrayList<Board> list = new ArrayList<Board>();		
		PreparedStatement pstmt = null;

		BoardDAO dao = new BoardDAO();
		list=dao.getboardlist();
		
		System.out.println("boardlistaction");
		return list;
	}
}
