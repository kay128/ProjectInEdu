package lab27.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab27.svc.PSelectOnePostService;
import lab27.vo.PostReplyVO;

public class PSelectOnePostAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int poN = Integer.parseInt((request.getParameter("post_id")).trim());
		String board_name = request.getParameter("board_name");
		int current_page = 0;
		try {
		 current_page = Integer.parseInt(request.getParameter("current_page"));
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		
		
		HashMap map = new HashMap();
		PSelectOnePostService service = new PSelectOnePostService();
		map.put("type", "hit");
		map.put("param", poN);
		
		ArrayList<PostReplyVO> postReplyList = service.selectOnePost(map);
		
		
		request.setAttribute("current_page", current_page);
		request.setAttribute("postReplyList", postReplyList);
		System.out.println(postReplyList.get(0).getBoard_name());
		if(postReplyList.get(0).getBoard_name().equals("free") || 
				postReplyList.get(0).getBoard_name().equals("exchange")) {
			RequestDispatcher dps = request.getRequestDispatcher("/product/product_view.jsp");
			dps.forward(request, response);
		}else {
			RequestDispatcher dps = request.getRequestDispatcher("");
			dps.forward(request, response);
		}	
		
	}

}
