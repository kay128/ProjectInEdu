package lab27.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import lab27.svc.EncSHA256Service;
import lab27.svc.MModifyActionService;
import lab27.vo.MemberVO;

public class MModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id;
		String pass;
		String name;
		int grade_id;
		String email;
		String phone;
		String location;
		String photo_or;
		String photo_sa;
		int admin;
		String type = "modify";

		HttpSession session = request.getSession();
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		MModifyActionService svc = new MModifyActionService();
		EncSHA256Service sha256 = new EncSHA256Service();
		ServletContext ctx = request.getServletContext();
		String realPath = null;
		
		String saveFolder = "/images";
		realPath = ctx.getRealPath(saveFolder);
		
		int maxSize = 5 * 1024 * 1024;			// 한번에 업로드 할 수 있는 파일의 크기 : 5MB
		String encType = "utf-8";
		
		MultipartRequest multi = new MultipartRequest(request, 
				  realPath, 
				  maxSize, 
				  encType, 
				  new DefaultFileRenamePolicy());
		
		
		user_id = loginUser.getUser_id();
		pass = sha256.getEncSHA256(multi.getParameter("pass"));
		name = loginUser.getName();
		grade_id = loginUser.getGrade_id();
		email = multi.getParameter("email");
		phone = multi.getParameter("phone");
		location = multi.getParameter("location");
		photo_or = multi.getFilesystemName("photo_or");
		photo_sa = loginUser.getUser_id()+".jpg";
		
		admin = loginUser.getAdmin();
		
		
		File or = new File(saveFolder+"/"+photo_or);
		File sa = new File(saveFolder+"/"+photo_sa);
		or.renameTo(sa);
		
		MemberVO mvo = new MemberVO(user_id, pass, name, grade_id, email, phone, location, photo_or, photo_sa, null, null,admin);
		HashMap map = new HashMap();
		map.put("type", type);
		map.put("mem", mvo);
		
		boolean result = svc.updateMember(map);
		
		if(result == true) {
			session.removeAttribute("loginUser");
			session.setAttribute("loginUser",mvo);	
		} else {
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('업데이트에 실패했습니다.');");
			out.print("history.back();");
			out.print("</script>");
			out.flush();
		}
		
	}

}
