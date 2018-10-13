package lab27.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab27.svc.EncSHA256Service;
import lab27.svc.MRegistService;
import lab27.vo.MemberVO;

public class MRegistAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EncSHA256Service svc = new EncSHA256Service();
		
		String pass = svc.getEncSHA256(request.getParameter("pass"));
		
		//Integer grade_id = Integer.parseInt(request.getParameter("grade_id"));
		
		MemberVO member = new MemberVO(
			  	request.getParameter("user_id"),
				 pass,
				 request.getParameter("name"),
				 Integer.parseInt(request.getParameter("grade_id")),
				 request.getParameter("email"),
				 request.getParameter("phone"),
				 request.getParameter("location"),
				 null,
				 null,
				 null,
				 null,
				 0 
				);
		
		System.out.println(member.toString());
		
		
		
		MRegistService service = new MRegistService();
		
		boolean check = service.memberRegist(member);
		
		
		
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		if(check == false) {
			out.print("<script>");
			out.print("alert('회원가입에 실패했습니다.');");
			out.print("history.back();");
			out.print("</script>");
			out.flush();
		}else {
			session.setAttribute("loginUser", member);
			response.sendRedirect("/lab27/index.jsp");
		}
		
		
	}

}
