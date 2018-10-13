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
import svc.BoardReplyService;
import svc.BoardshowService;
import svc.BoardviewService;

public class BoardReplyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userEmail = request.getParameter("userEmail");
		int parentId = Integer.parseInt(request.getParameter("parentId"));
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		
		System.out.println(userEmail);
		System.out.println(parentId);
		System.out.println(boardTitle);
		System.out.println(boardContent);
		
		Date dt = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		System.out.println(date.format(dt));
		
		String boardDate= date.format(dt);
		
		//부모 board 정보 가져오기
		Board parentBoard = new Board();

		BoardshowService svc = new BoardshowService();
		parentBoard = svc.getboardById(parentId);
		
		
		/*(String userEmail, String boardTitle, String boardContent, String boardDate, int boardHit, int boardGroup)*/ 
		
		Board board = new Board(userEmail, boardTitle, boardContent, boardDate, 0 , parentId);
		
		BoardReplyService replySvc = new BoardReplyService();
		boolean result = replySvc.boardReply(board,parentBoard);
		
		ActionForward af = null;
		
		if(result) {
			
			ArrayList<Board> list = new ArrayList<Board>();
			
			BoardviewService  viewsvc = new BoardviewService();
			list=viewsvc.getboardlist();
			
			request.setAttribute("boardlist", list);
			af = new ActionForward("boardlist.jsp", false);
		}
		
		
		return af;
	}

}
