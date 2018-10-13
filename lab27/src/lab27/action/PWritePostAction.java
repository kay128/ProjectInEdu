package lab27.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import lab27.svc.PSelectOnePostService;
import lab27.svc.PSelectPostService;
import lab27.svc.PWrtiePostService;
import lab27.vo.MemberVO;
import lab27.vo.PostReplyVO;
import lab27.vo.PostVO;

public class PWritePostAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		MemberVO member = (MemberVO) session.getAttribute("loginUser");
		
		ServletContext ctx = request.getServletContext();
		
		String realPath = null;
		
		String saveFolder = "images";
		
		realPath = ctx.getRealPath(saveFolder);
		
		int maxSize = 5 * 1024 * 1024;
		String encType = "utf-8";
		
		MultipartRequest multi = new MultipartRequest(request,
				realPath,
				maxSize,
				encType,
				new DefaultFileRenamePolicy());
		
		PostVO post = new PostVO(
				0,
				member.getUser_id(),
				null,
				0,
				0,
				multi.getParameter("title"),
				multi.getParameter("content"),
				multi.getFilesystemName("photo_or")+".jpg",
				multi.getParameter("title"),
				multi.getParameter("board_name")
				);
		
		PWrtiePostService service = new PWrtiePostService();
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		System.out.println("P_write_1");
		
		boolean check = service.postWrite(post);
		
		System.out.println("P_wirte_2");
		
		if(check == false) {
			    out.print("<script>");
				out.print("alert('게시글 작성에 실패했습니다.');");
				out.print("history.back();");
				out.print("</script>");
				out.flush();
		}else {
			HashMap map = new HashMap();
			
			map.put("param", member.getUser_id());
			
			map.put("type", "user_id");
			
			System.out.println("p_write 3");
			
			PSelectPostService service3 = new PSelectPostService();
			//PWritePostService 
								
			ArrayList<PostVO> write_post = service3.selectPost(map);
			//ArrayList<PostVO> write_post = service3.
			System.out.println("p_write_4");
			
			//for(int i=0;i<write_post.size();i++) {
				System.out.println(write_post.get(0).getPost_id());
			//}
			
			PSelectOnePostService service2 = new PSelectOnePostService();
			
			map.remove("param");
			
			map.put("param", write_post.get(0).getPost_id());
			
			
			
			ArrayList<PostReplyVO> postReplyList = service2.selectOnePost(map);
			
			request.setAttribute("postReplyList", postReplyList);
			
			RequestDispatcher rdp = request.getRequestDispatcher("/product/product_view.jsp");
			
			rdp.forward(request, response);
		}
		
	}
	
}
