package lab27.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab27.svc.PSelectOnePostService;
import lab27.vo.PostReplyVO;

public class PUpdatePostFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String board_name = request.getParameter("board_name");
		int current_page = 0;
		try {
		 current_page = Integer.parseInt(request.getParameter("current_page"));
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		int post_id = 0;
		try {
			 post_id = Integer.parseInt(request.getParameter("post_id"));
			 }catch(Exception e) {
				 e.printStackTrace();
			 }
		PSelectOnePostService service = new PSelectOnePostService();
		ArrayList<PostReplyVO> postReplyList = service.selectOnePost(null);
		
		request.setAttribute("current_page", current_page);
		request.setAttribute("postReplyList", postReplyList);
		
		RequestDispatcher dps = request.getRequestDispatcher("");
		dps.forward(request, response);
	}

}
