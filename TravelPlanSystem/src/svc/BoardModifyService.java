package svc;

import dao.BoardDAO;
import model.Board;

public class BoardModifyService {

	public boolean modifyBoard(Board board) {
		BoardDAO dao = new BoardDAO();
		int result = dao.modifyBoard(board);
		
		if(result>0) {
			return true;
		}else {
			return false;
		}
		
	}

}
