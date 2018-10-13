package svc;

import dao.BoardDAO;
import model.Board;

public class BoardwriteService {

	public boolean insertboard(Board newBoard) {
		BoardDAO dao = new BoardDAO();
		int result=dao.insertBoard(newBoard);
		
		
		if(result>0){
		return true;	
		}else {
		return false;
		}
	}

}
