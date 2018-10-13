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
import lab27.svc.CSelectOneCAllService;
import lab27.svc.PSelectPostService;
import lab27.vo.CAllVO;
import lab27.vo.MemberVO;
import lab27.vo.Paging;
import lab27.vo.PostVO;

public class CSelectOneCommunity implements Action {

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String board_name = request.getParameter("c_name");
      HashMap map = new HashMap();

      HttpSession session = request.getSession();
      MemberVO vo = (MemberVO) session.getAttribute("loginUser");

      map.put("type", "user_id");
      map.put("param", vo.getUser_id());

      CFavoriteService service = new CFavoriteService();
      ArrayList<CAllVO> joinList = service.selectFavorite(map);
      int count = 0;

      if (joinList.size() == 0) {
         request.setAttribute("c_name", board_name);
         request.setAttribute("is_join", "true");
         RequestDispatcher rdp = request.getRequestDispatcher("community-page.jsp");
         rdp.forward(request, response);
         return;
      }

      for (int i = 0; i < joinList.size(); i++) {
         if (joinList.get(i).getUser_id().equals(vo.getUser_id())) {
            if (joinList.get(i).getC_name().equals(board_name)) {
               count++;
            }
         }
      }

      if (count >= 1) {
         int current_page = 1;
         try {
            current_page = Integer.parseInt(request.getParameter("current_page"));
         } catch (Exception e) {
            current_page = 1;
            e.printStackTrace();
         }

         map.put("type", "board_name");
         map.put("param", board_name);

         PSelectPostService postService = new PSelectPostService();
         ArrayList<PostVO> postList = postService.selectPost(map);

         map.put("type", "c_name");
         request.setAttribute("is_join", "false");

         CSelectOneCAllService comuService = new CSelectOneCAllService();
         ArrayList<CAllVO> cAll = comuService.getCAllOne(map);

         int total_count = postList.size();

         Paging paging = new Paging(current_page, total_count, null);
         /*
          * <s:subset source="postList" count="5" start="page.st_inlist"> "페이징 처리"
          * <s:property value="en_page_html" escape="false"/> "버튼 출력"
          */

         request.setAttribute("cAll", cAll);
         request.setAttribute("postList", postList);
         request.setAttribute("paging", paging);

         RequestDispatcher rdp = request.getRequestDispatcher("community-page.jsp");
         rdp.forward(request, response);

      } else {
         request.setAttribute("c_name", board_name);
         request.setAttribute("is_join", "true");
         RequestDispatcher rdp = request.getRequestDispatcher("community-page.jsp");
         rdp.forward(request, response);
         return;
      }
   }

}