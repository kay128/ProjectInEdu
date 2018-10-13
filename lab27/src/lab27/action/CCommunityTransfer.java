package lab27.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab27.svc.CSelectOneCAllService;
import lab27.svc.CSelectOneCommunityService;
import lab27.svc.CUpdateCommunityService;
import lab27.svc.PSelectPostService;
import lab27.vo.CAllVO;
import lab27.vo.CommunityVO;
import lab27.vo.MemberVO;
import lab27.vo.PostVO;

public class CCommunityTransfer implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String transferMember = request.getParameter("member_id");
		HttpSession session = request.getSession();
		MemberVO master = (MemberVO) session.getAttribute("loginUser");
		String board_name = request.getParameter("c_name");
		
		HashMap map = new HashMap();
		map.put("type", "c_master");
		map.put("param", transferMember);
		
		CSelectOneCommunityService svc1 = new CSelectOneCommunityService();
		CommunityVO vo = svc1.oneCommuGet(map);
		PrintWriter out = response.getWriter();
		if(vo != null) {
			
			out.print("<script>");
			out.print("alert('해당 회원은 이미 커뮤니티를 생성하였습니다.');");
			out.print("history.back();");
			out.print("</script>");
			out.flush();
			
		} else {
			CUpdateCommunityService svc = new CUpdateCommunityService();
			boolean result = svc.updateCommunity(map);
			
			
			if(result == true) {
				map.put("type", "board_name");
				map.put("param", board_name);
				
				PSelectPostService postService = new PSelectPostService();
				ArrayList<PostVO> postList = postService.selectPost(map);		
				
				map.put("type", "c_name");
				
				CSelectOneCAllService comuService = new CSelectOneCAllService();
				ArrayList<CAllVO> cAll = comuService.getCAllOne(map);
				
				request.setAttribute("cAll", cAll);
				request.setAttribute("postList", postList);
				
				RequestDispatcher rdp = request.getRequestDispatcher("");
				rdp.forward(request, response);
				
			}else {
				
				out.print("<script>");
				out.print("alert('커뮤니티 양도에 실패하였습니다.');");
				out.print("history.back();");
				out.print("</script>");
				out.flush();
				
			}
			
			
			
		}
		
		
	}

}
