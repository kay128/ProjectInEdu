package lab27.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import lab27.svc.PSelectOnePostService;
import lab27.svc.PUpdatePostService;
import lab27.vo.MemberVO;
import lab27.vo.PostReplyVO;
import lab27.vo.PostVO;

public class PUpdatePostAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int current_page = 0;
		try {
		 current_page = Integer.parseInt(request.getParameter("current_page"));
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		
		HttpSession session = request.getSession();
		
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		
		ServletContext ctx = request.getServletContext();
		
		
		String realPath = null;
		
		String saveFolder = "/images";
		
		realPath = ctx.getRealPath(saveFolder);
		
		PostVO post = null;
		
		int maxSize = 5 * 1024 * 1024;
		
		String encType = "utf-8";
		
		MultipartRequest multi = null;
		
		PUpdatePostService service = new PUpdatePostService();
		
		if(member.getPass().equals(request.getParameter("pass"))) {
			multi = new MultipartRequest(request,
					realPath,
					maxSize,
					encType,
					new DefaultFileRenamePolicy());
			
			 post = new PostVO(
					Integer.parseInt(multi.getParameter("post_id")),
					member.getUser_id(),
					null,
					0,
					0,
					multi.getParameter("title"),
					multi.getParameter("content"),
					multi.getFilesystemName("photo_or"),
					multi.getParameter("title")+".jpg",
					multi.getParameter("board_name")
					);
		}
		
		HashMap map = new HashMap();
		map.put("type", "modi_post");
		map.put("modi_post", post);
		PrintWriter out = response.getWriter();
		
		boolean result = service.postUpdate(map);
		PSelectOnePostService service2 = new PSelectOnePostService();
		ArrayList<PostReplyVO> postReplyList = service2.selectOnePost(null);
		
		 if(result == true) {
				 RequestDispatcher rdp = request.getRequestDispatcher("");
					request.setAttribute("postReplyList", postReplyList);
				 rdp.forward(request, response);
		 } else {
			 out.print("<script>");
				out.print("alert('업데이트에 실패했습니다.');");
				out.print("history.back();");
				out.print("</script>");
				out.flush();
		 }
		 
	}

}
