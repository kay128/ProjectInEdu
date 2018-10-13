package lab27.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab27.svc.CFavoriteService;

import lab27.svc.CGetCommunityListService;
import lab27.svc.MGetMyCommuService;
import lab27.vo.CAllVO;
import lab27.vo.CommunityVO;
import lab27.vo.MemberVO;

public class CCommunityMainAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		MemberVO vo = (MemberVO) session.getAttribute("loginUser");
		
		HashMap map = new HashMap();
		map.put("type", "user_id");
		map.put("param", vo.getUser_id());
		
		CFavoriteService service = new CFavoriteService();
		ArrayList<CAllVO> joinList = service.selectFavorite(map);
		
		map.put("type", "c_master");
		map.put("param", vo.getUser_id());
		
		MGetMyCommuService myCommuSvc = new MGetMyCommuService();
		
		ArrayList<CAllVO> myCommu = myCommuSvc.getMyCommunity(map);
		
		
		map.put("type", "favorite");
		ArrayList<CAllVO> favoriteList = service.selectFavorite(map);
		
		map.put("type", "all");
		
		CGetCommunityListService service2 = new CGetCommunityListService();
		ArrayList<CommunityVO> allCommu = service2.getAllCommunity(map);
		
		
		request.setAttribute("favoriteList", favoriteList);
		request.setAttribute("joinList", joinList);
		request.setAttribute("allCommu", allCommu);
		request.setAttribute("myCommu", myCommu);
		
		RequestDispatcher rdp = request.getRequestDispatcher("/community.jsp");
		rdp.forward(request, response);
		
	}
	
}
