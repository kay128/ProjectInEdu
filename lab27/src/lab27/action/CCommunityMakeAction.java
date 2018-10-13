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

import lab27.svc.CCommunityMakeService;
import lab27.svc.CSelectOneCAllService;
import lab27.svc.CSelectOneCommunityService;
import lab27.svc.PSelectPostService;
import lab27.vo.CAllVO;
import lab27.vo.CommunityVO;
import lab27.vo.MemberVO;
import lab27.vo.PostVO;

public class CCommunityMakeAction implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      HttpSession session = request.getSession();
      MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
      
      String c_name = request.getParameter("c_name");
      String c_theme = request.getParameter("c_theme");
      
      CommunityVO commu = new CommunityVO(c_name,
                                 c_theme,
                                 null,
                                 loginUser.getUser_id());
      
      CCommunityMakeService service = new CCommunityMakeService();
      boolean result = false;
      HashMap map = new HashMap();
      map.put("type", "c_name");
      map.put("param", c_name);
      CSelectOneCommunityService commuSVC = new CSelectOneCommunityService();
       CommunityVO commu2 = commuSVC.oneCommuGet(map);
      
       
       if(commu2 != null) {
       result = service.communityMake(commu);
      }
      
      
      if(result == true) {
         
         
         map.put("type", "board_name");
         map.put("param", c_name);
         
         PSelectPostService postService = new PSelectPostService();
         ArrayList<PostVO> postList = postService.selectPost(map);      
         
         map.put("type", "c_name");
         
         CSelectOneCAllService comuService = new CSelectOneCAllService();
         ArrayList<CAllVO> cAll = comuService.getCAllOne(map);
         
         request.setAttribute("cAll", cAll);
         request.setAttribute("postList", postList);
         
         RequestDispatcher rdp = request.getRequestDispatcher("");
         rdp.forward(request, response);
      
      } else {
         PrintWriter out = response.getWriter();
         out.print("<script>");
         out.print("alert('커뮤니티 생성에 실패했습니다.');");
         out.print("history.back();");
         out.print("</script>");
         out.flush();
         
      }
      
   }

}