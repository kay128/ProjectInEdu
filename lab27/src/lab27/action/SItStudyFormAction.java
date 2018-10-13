package lab27.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab27.svc.MModifyActionService;
import lab27.vo.MemberVO;

public class SItStudyFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String study_it = request.getParameter("study_it");
		String type= "study_i";
		
		HttpSession session = request.getSession();
		MemberVO vo = (MemberVO) session.getAttribute("loginUser");
		vo.setStudy_it(study_it);
		HashMap map = new HashMap();
		
		map.put("type",type);
		map.put("param", vo);
		MModifyActionService service = new MModifyActionService();
		boolean result = service.updateMember(map);
		if(result == false) {
			
		}
		
		response.sendRedirect(""+study_it);
		
	}
	
}
