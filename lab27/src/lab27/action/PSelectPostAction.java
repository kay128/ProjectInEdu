package lab27.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lab27.svc.PSelectPostService;
import lab27.vo.Paging;
import lab27.vo.PostVO;

public class PSelectPostAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String board_name = request.getParameter("board_name");
		int current_page = 0;
		try {
		 current_page = Integer.parseInt(request.getParameter("current_page"));
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		
		HashMap params = new HashMap();
		
		params.put("type", "board_name");
		params.put("param", board_name);
		
		ArrayList<PostVO> postList = new ArrayList<PostVO>();
		PSelectPostService service = new PSelectPostService();
		
		postList = service.selectPost(params);
		
		int total_count = postList.size();
		
		Paging paging = new Paging(current_page, total_count, board_name);
		/*<s:subset source="postList" count="5" start="page.st_inlist"> "페이징 처리"
		 * <s:property value="en_page_html" escape="false"/> "버튼 출력"*/
				
		
		request.setAttribute("paging", paging);
		request.setAttribute("postList", postList);
		
		RequestDispatcher dps = request.getRequestDispatcher("product/market.lab27?command=market_list");
		dps.forward(request, response);
		
	}

}
