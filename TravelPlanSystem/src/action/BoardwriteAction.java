package action;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import model.Board;
import svc.BoardviewService;
import svc.BoardwriteService;

public class BoardwriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("userEmail");
		String title = request.getParameter("boardTitle");
		String content = request.getParameter("boardContent");
		
		Date dt = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		System.out.println(date.format(dt));
		
		String currentTime = String.valueOf(date.format(dt));
		
		Board newBoard = new Board(email, title, content, currentTime, 0);
		BoardwriteService svc = new BoardwriteService();
		boolean result = svc.insertboard(newBoard);
		
		ActionForward af = null;
		if(result ){
			
			ArrayList<Board> list = new ArrayList<Board>();
			
			BoardviewService  viewsvc = new BoardviewService();
			list=viewsvc.getboardlist();
			
			request.setAttribute("boardlist", list);
			
			af = new ActionForward("boardlist.jsp", false);
			
		}
		return af;
	}

}
