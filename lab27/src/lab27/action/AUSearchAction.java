package lab27.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab27.svc.AUSearchService;
import lab27.vo.MemberVO;

public class AUSearchAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap map = new HashMap();
		AUSearchService service = new AUSearchService();
		ArrayList<MemberVO> vo = null;
		int check = 2;
		
		HttpSession session = request.getSession();
		session.setAttribute("check", check);
		
		System.out.println("a user search action()");
		
		String name = request.getParameter("name");
		System.out.println("name : " + name);
		String grade = request.getParameter("grade");
		System.out.println("grade: " + grade);
		
		if(request.getParameter("name") != null) {
			map.put("type", "name");
			//String name = request.getParameter("name");
			//System.out.println("name : " + name);
			
			map.put("param", request.getParameter("name"));
			
			vo = service.getMemberSearch(map);
			
			for(int i=0;i<vo.size();i++) {
				System.out.println("search name: "+ vo.get(i).getName());
			}
			
			request.setAttribute("memberName", vo);
		}else if(request.getParameter("grade") != null) {
			map.put("type", "grade");
			map.put("param", request.getParameter("grade"));
			vo = service.getMemberSearch(map);
			
			request.setAttribute("memberName", vo);
		}
		
		RequestDispatcher rdp = request.getRequestDispatcher("/admin/admin.jsp");
		rdp.forward(request, response);
		
	}
	
}
