package lab27.action;

import java.io.IOException;
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

public class RUpdateReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReplyVO vo = new ReplyVO();
		
		String type ="content";
		
		vo.setContent(request.getParameter("content"));
		
		vo.setReply_id(Integer.parseInt("reply_id"));
		
		int poN = Integer.parseInt(request.getParameter("post_id"));
		
		vo.setPost_id(poN);
		
		HashMap map = new HashMap();
		
		map.put("type", type);
		map.put("reply", vo);
		map.put("post_id", poN);
		
		RUpdateReplyService service = new RUpdateReplyService();
	 	
		boolean result = service.replyUpdate(map);
		
		if(result ==true) {
			PSelectOnePostService service2 = new PSelectOnePostService();
			ArrayList<PostReplyVO> postReplyList = service2.selectOnePost(map);
			request.setAttribute("postReplyList", postReplyList);
			RequestDispatcher dps = request.getRequestDispatcher("");
			dps.forward(request, response);
		}else {
			
			
		}
	}

}
