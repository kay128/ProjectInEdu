package action;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import model.Board;
import svc.BoardviewService;

public class BoardviewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 System.out.println("boardviewaction");
		
		ArrayList<Board> list = new ArrayList<Board>();
		
		BoardviewService  svc = new BoardviewService();
		list=svc.getboardlist();
		
		request.setAttribute("boardlist", list);	
		ActionForward af = null;
		af = new ActionForward("boardlist.jsp", false);
		return af;
	}

}
