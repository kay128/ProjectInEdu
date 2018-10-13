package svc;

import dao.BoardDAO;

public class BoardDeleteService {

	public boolean boardDeleteById(int boardId, String boardDate) {
		BoardDAO dao = new BoardDAO();
		int result = dao.deleteBoardbyId(boardId, boardDate);
		
		if(result >0) {
			return true;
		}else {
			return false;
		}
		
	}

}
