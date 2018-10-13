package svc;

import dao.BoardDAO;
import model.Board;

public class BoardshowService {

	public Board getboardById(int boardId) {
		Board board = null;
		BoardDAO dao = new BoardDAO();
		//dao.getUpdateHit(boardId);
		board = dao.getboardById(boardId);
		
		return board;
		
	}

}
