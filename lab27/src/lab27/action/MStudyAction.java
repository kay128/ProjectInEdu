package lab27.action;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab27.svc.MStudyService;
import lab27.vo.MemberVO;

public class MStudyAction implements Action {
   
   
   
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String study_it;
      String study_jp;
      HashMap<String, String> hash = new HashMap<String, String>();
      
      study_it = request.getParameter("study_it");
      study_jp = request.getParameter("study_jp");
      
      MStudyService svc = new MStudyService(); 
      HttpSession session = request.getSession();
      MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
      
      if(study_it != null) {
         hash.put("study_it", study_it);
      }else{
         hash.put("study_jp", study_jp);
      }
      
      int result = svc.update(hash);
      
      if(result > 0) {
         if(study_it != null) {
            loginUser.setStudy_it(study_it);
         }else{
            loginUser.setStudy_jp(study_jp);
         }
         session.removeAttribute("loginUser");
         session.setAttribute("loginUser",loginUser);   
      }
   }
}