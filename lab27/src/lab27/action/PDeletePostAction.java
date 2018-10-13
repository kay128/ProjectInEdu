package lab27.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab27.svc.EncSHA256Service;
import lab27.svc.PDeletePostService;
import lab27.vo.MemberVO;

public class PDeletePostAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PDeletePostService service = new PDeletePostService();
		HttpSession session = request.getSession();
		boolean result = false;
		
		EncSHA256Service eservice = new EncSHA256Service();
		
		MemberVO vo = (MemberVO) session.getAttribute("loginUser");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String board_name = request.getParameter("board_name");
		int current_page = 0;
		try {
		 current_page = Integer.parseInt(request.getParameter("current_page"));
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		
		if(vo.getPass().equals(eservice.getEncSHA256(request.getParameter("pass")))) {
			result = service.postDelete(Integer.parseInt(request.getParameter("post_id")));
		} else {
			
			out.print("<script>");
			out.print("alert('비밀번호가 일치하지 않습니다.');");
			out.print("history.back();");
			out.print("</script>");
			out.flush();
		}
		
		
		if(result == true) {
			request.setAttribute("current_page", current_page);
			request.setAttribute("board_name", board_name);
			
			RequestDispatcher dps = request.getRequestDispatcher("market.lab27?command=p_select_post");
			dps.forward(request, response);
			
		} else {
			
			out.print("<script>");
			out.print("alert('삭제에 실패했습니다.');");
			out.print("history.back();");
			out.print("</script>");
			out.flush();
		}
		
		
	}
	
}
