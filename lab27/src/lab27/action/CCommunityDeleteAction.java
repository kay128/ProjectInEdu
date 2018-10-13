package lab27.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab27.svc.CCommunityDeleteService;

public class CCommunityDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String c_name = request.getParameter("c_name");
		
		CCommunityDeleteService service = new CCommunityDeleteService();
		boolean result = service.deleteCommunity(c_name);
		
		if(result == false) {
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('커뮤니티 삭제에 실패했습니다.');");
			out.print("history.back();");
			out.print("</script>");
			out.flush();
		} else {
		
		}
		
	}
	
}
