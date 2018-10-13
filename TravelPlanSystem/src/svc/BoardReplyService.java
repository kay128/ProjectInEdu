package svc;

import dao.BoardDAO;
import model.Board;

public class BoardReplyService {

	public boolean boardReply(Board board, Board parentBoard) {
		BoardDAO dao = new BoardDAO();
		int result = dao.replyBoard(board,parentBoard);
		
		if(result>0) {
			return true;
		}else {
			return false;
		}
		
		
	}

}
