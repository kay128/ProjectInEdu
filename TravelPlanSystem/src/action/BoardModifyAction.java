package action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import model.Board;
import svc.BoardModifyService;
import svc.BoardviewService;

public class BoardModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		String userEmail = request.getParameter("userEmail");
		
		System.out.println(boardId);
		System.out.println(boardTitle);
		System.out.println(boardContent);
		System.out.println(userEmail);
		
		Date dt = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		System.out.println(date.format(dt));
		
		String boardDate = String.valueOf(date.format(dt));
		
		Board board = new Board(boardId, userEmail, boardTitle, boardContent, boardDate);
		
		BoardModifyService svc = new BoardModifyService();
		boolean result = svc.modifyBoard(board);
		
		ActionForward af = null;
		
		if(result) {
			
			ArrayList<Board> list = new ArrayList<Board>();
			
			BoardviewService  viewsvc = new BoardviewService();
			list=viewsvc.getboardlist();
			
			request.setAttribute("boardlist", list);
			
			af = new ActionForward("boardlist.jsp",false);
		}
		
		
		
		
		
		return af;
	}

}
