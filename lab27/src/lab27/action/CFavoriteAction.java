package lab27.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab27.svc.CFavoriteUpdateService;
import lab27.vo.CMemberVO;
import lab27.vo.MemberVO;

public class CFavoriteAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();
      String route = request.getParameter("rts");
      MemberVO member = (MemberVO) session.getAttribute("loginUser");
      CMemberVO cMem = new CMemberVO( request.getParameter("sel1"),
                              member.getUser_id(),
                              1,
                              0
                              );
      
      CMemberVO cMem2 = new CMemberVO( request.getParameter("sel2"),
                              member.getUser_id(),
                              1,
                              0
                              );
   
      CMemberVO cMem3 = new CMemberVO( request.getParameter("sel3"),
                              member.getUser_id(),
                              1,
                              0
                              );
      
      CFavoriteUpdateService service = new CFavoriteUpdateService();
      service.updateFavorite(cMem);
      service.updateFavorite(cMem2);
      service.updateFavorite(cMem3);
      
      response.sendRedirect("/lab27/"+route+".jsp");
      
      
   }

}