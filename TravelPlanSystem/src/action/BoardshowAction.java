package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import model.Board;
import svc.BoardshowService;

public class BoardshowAction implements Action  {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Board board = null;
		
		
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		String type= request.getParameter("type");
		
		
		BoardshowService svc = new BoardshowService();
		board = svc.getboardById(boardId);
		
		request.setAttribute("boardshow", board);
		
		ActionForward af = null;
		if(type.equals("modify")) {
			af = new ActionForward("boardmodify.jsp",false);
		}else {
			af = new ActionForward("boardshow.jsp", false);
		}
		
		
		return af;
	}

}
