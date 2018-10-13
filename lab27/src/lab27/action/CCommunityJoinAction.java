package lab27.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab27.svc.CCommunityJoinService;
import lab27.vo.CMemberVO;
import lab27.vo.MemberVO;

public class CCommunityJoinAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();
      MemberVO vo = (MemberVO) session.getAttribute("loginUser");
      CMemberVO cMem = new CMemberVO( request.getParameter("c_name"),
                              vo.getUser_id(),
                              0,
                              0
                              );
      
      CCommunityJoinService service = new CCommunityJoinService();
      boolean result = service.joinCommunity(cMem);
      
      if(result == true ) {
         RequestDispatcher rdp = request.getRequestDispatcher("community_page.lab27?command=communityPage & c_name="+cMem.getC_name());
         rdp.forward(request, response);
      } else {
         RequestDispatcher rdp = request.getRequestDispatcher("community_main.lab27?command=communityMain");
         rdp.forward(request, response);
      }
      
      
   }

}