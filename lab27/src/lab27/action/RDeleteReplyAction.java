package lab27.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab27.svc.PSelectOnePostService;
import lab27.svc.RUpdateReplyService;
import lab27.vo.PostReplyVO;
import lab27.vo.ReplyVO;

public class RDeleteReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReplyVO vo = new ReplyVO();
		
		String type = "is_del";
		
		vo.setReply_id(Integer.parseInt(request.getParameter("reply_id")));
		
		int poN = Integer.parseInt(request.getParameter("post_id"));
		
		vo.setIs_del(Integer.parseInt(request.getParameter("is_del")));
		
		HashMap map = new HashMap();
		map.put("reply", vo);
		map.put("post_id", poN);
		map.put("type", type);
		RUpdateReplyService service = new RUpdateReplyService();
	 	
		boolean result = service.replyUpdate(map);
		
		if(result == true) {
			PSelectOnePostService service2 = new PSelectOnePostService();
			ArrayList<PostReplyVO> postReplyList = service2.selectOnePost(map);
			request.setAttribute("postReplyList", postReplyList);
			RequestDispatcher dps = request.getRequestDispatcher("");
			dps.forward(request, response);
			 
		} else {
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('삭제에 실패했습니다.');");
			out.print("history.back();");
			out.print("</script>");
			out.flush();
		}
		
		
	}

}
