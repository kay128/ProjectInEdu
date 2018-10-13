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

public class PMarketListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int current_page = 1;
		try {
		 current_page = Integer.parseInt(request.getParameter("current_page"));
		 }catch(Exception e) {
			 current_page = 1;
			 e.printStackTrace();
		 }
		
		HashMap params = new HashMap();
		
		params.put("type", "market");
		params.put("board_name1", "free");
		params.put("board_name2", "exchange");
		
		ArrayList<PostVO> postList = new ArrayList<PostVO>();
		PSelectPostService service = new PSelectPostService();

		postList = service.selectPost(params);		
		
		int total_count = postList.size();
		
		Paging paging = new Paging(current_page, total_count, null);
		/*<s:subset source="postList" count="5" start="page.st_inlist"> "페이징 처리"
		 * <s:property value="en_page_html" escape="false"/> "버튼 출력"*/
		
		
		request.setAttribute("paging", paging);
		request.setAttribute("postList", postList);
		
		RequestDispatcher dps = request.getRequestDispatcher("/product/product_list.jsp");
		dps.forward(request, response);

	}

}
