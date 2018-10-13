package lab27.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab27.svc.DeletePavoriteService;
import lab27.vo.MemberVO;



public class DeletePavoriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		String user_id=member.getUser_id();
		
		
		int company_id = Integer.parseInt(request.getParameter("company_id"));
		DeletePavoriteService svc = new DeletePavoriteService();
		boolean result = svc.deletePavorite(user_id, company_id);
		
		response.setContentType("text/html; charset=utf-8");
		

		if(result) {
		response.getWriter().write("success");
		return;
		}else {
			response.getWriter().write("관심 기업 취소에 실패하였습니다.");
			return;
		}
		
	}

}


