package lab27.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab27.svc.CGetCommunityListService;
import lab27.vo.CommunityVO;

public class ACSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HashMap map = new HashMap();
		
		int check = 4;
		
		HttpSession session = request.getSession();
		session.setAttribute("check", check);
		
		map.put("type", "period");
		//map.put("param", request.getParameter("param"));
		map.put("start_day",request.getParameter("start_day"));
		System.out.println("start_day: " +request.getParameter("start_day"));
		map.put("end_day", request.getParameter("end_day"));
		System.out.println("end_day: " + request.getParameter("end_day"));
		
		CGetCommunityListService service = new CGetCommunityListService();
		
		ArrayList<CommunityVO> vo =  service.getAllCommunity(map);
		
		for(int i=0; i<vo.size();i++) {
			System.out.println("commu: name"+vo.get(i).getC_name());
			System.out.println("commu: count"+vo.get(i).getC_number());
		}
		
		request.setAttribute("allCommu", vo);
		
		RequestDispatcher rdp = request.getRequestDispatcher("/admin/admin.jsp");
		
		rdp.forward(request, response);
		
	}
	
}
