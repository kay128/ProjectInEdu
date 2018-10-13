package lab27.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab27.svc.CCommunityDropService;
import lab27.vo.CMemberVO;
import lab27.vo.MemberVO;

public class CCommunityDropAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String c_name = request.getParameter("c_name");
		MemberVO vo = (MemberVO) session.getAttribute("loginUser");
		CMemberVO cMem = new CMemberVO(c_name,
										vo.getUser_id(),
										0,
										0
										);
		
		CCommunityDropService service = new CCommunityDropService();
		boolean result = service.CDropCMemberService(cMem);
		if(result==true) {
			response.sendRedirect("communityMain.lab27?command =communityMain");
		} else {
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('커뮤니티 탈퇴에 실패했습니다.');");
			out.print("history.back();");
			out.print("</script>");
			out.flush();

		}
		
		
	}

}
