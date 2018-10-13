package lab27.action;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab27.svc.MModifyActionService;
import lab27.vo.MemberVO;

public class SJpStudyFormAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String study_jp = request.getParameter("study_jp");
      String type= "study_j";
      
      HttpSession session = request.getSession();
      MemberVO vo = (MemberVO) session.getAttribute("loginUser");
      vo.setStudy_it(study_jp);
      HashMap map = new HashMap();
      
      map.put("type",type);
      map.put("param", vo);
      MModifyActionService service = new MModifyActionService();
      boolean result = service.updateMember(map);
      
      response.sendRedirect("/lab27/study/japan/"+study_jp+".jsp");
      
   }

}