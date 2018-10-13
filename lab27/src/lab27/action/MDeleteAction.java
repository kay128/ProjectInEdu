package lab27.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab27.svc.MDeleteService;
import lab27.vo.MemberVO;

public class MDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		MemberVO vo = (MemberVO) session.getAttribute("loginUser");
		boolean result = false;
		MDeleteService service = new MDeleteService();
		
		result = service.deleteMember(vo);
		
		if(result == true) {
			
			session.removeAttribute("loginUser");
			response.sendRedirect("Lab27/index.jsp");
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
