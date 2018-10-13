package lab27.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab27.svc.PSelectOnePostService;
import lab27.svc.RWriteReplyService;
import lab27.vo.MemberVO;
import lab27.vo.PostReplyVO;
import lab27.vo.ReplyVO;


public class RWriteReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		
		ReplyVO reply = new ReplyVO(0,
									Integer.parseInt(request.getParameter("post_id")),
									member.getUser_id(),
									null,
									Integer.parseInt(request.getParameter("lev")),
									Integer.parseInt(request.getParameter("sort")),
									0,
									request.getParameter("r_content"),
									0
								);
		
		RWriteReplyService service = new RWriteReplyService();
		
		boolean result = service.replyWrite(reply);
		
		HashMap map = new HashMap();
		
		map.put("post_id", reply.getPost_id());
		
		if(result == true) {
			PSelectOnePostService service2 = new PSelectOnePostService();
			ArrayList<PostReplyVO> postReplyList = service2.selectOnePost(map);
			request.setAttribute("postReplyList", postReplyList);
			RequestDispatcher rdp = request.getRequestDispatcher("");
			rdp.forward(request, response);
		}else {
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('댓글달기에 실패했습니다.');");
			out.print("history.back();");
			out.print("</script>");
			out.flush();
		}
		
		
		
	}

}
