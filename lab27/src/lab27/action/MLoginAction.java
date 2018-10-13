package lab27.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lab27.svc.EncSHA256Service;
import lab27.svc.MLoginService;
import lab27.vo.MemberVO;

public class MLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EncSHA256Service service = new EncSHA256Service();
		String user_id = request.getParameter("user_id");
		String pass = service.getEncSHA256(request.getParameter("pass"));
		
		System.out.println("user_id: "+ user_id);
		System.out.println("pass: " + pass);
		
		MLoginService svc = new MLoginService();
		MemberVO loginUser = new MemberVO();
		loginUser.setUser_id(user_id);
		loginUser.setPass(pass);
		loginUser = svc.login(loginUser);
		
		
		if(loginUser != null) {
			if(loginUser.getAdmin() == 1) {
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", loginUser);
				response.sendRedirect("index.jsp");
			}else {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			response.sendRedirect("index.jsp");
			}
		}else {
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('로그인에 실패했습니다.');");
			out.print("history.back();");
			out.print("</script>");
			out.flush();
		}

	}

}
