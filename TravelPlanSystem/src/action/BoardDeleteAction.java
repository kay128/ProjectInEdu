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
import svc.BoardDeleteService;
import svc.BoardviewService;

public class BoardDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		
		Date dt = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		System.out.println(date.format(dt));
		
		String boardDate = date.format(dt);
		
		BoardDeleteService svc = new BoardDeleteService();
		boolean result = svc.boardDeleteById(boardId, boardDate);
		
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
