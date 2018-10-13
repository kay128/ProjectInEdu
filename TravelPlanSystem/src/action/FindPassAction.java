package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import dao.CustomerDAO;

public class FindPassAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward af;
		response.setContentType("text/html; charset = utf-8");
		
		String password = null;
		String email = null;
		
		email = request.getParameter("email");
		CustomerDAO dao = new CustomerDAO();
		password = dao.findPass(email);
		
		if(password != null) {
			af = new ActionForward("/login.jsp", false);
			request.setAttribute("message2", "パスワードは "+password+"です。");
		}else {
			af = new ActionForward("/find.jsp", false);
			request.setAttribute("message3", "該当するメールアドレス情報を確認できません。");
		}
		return af;
	}

}
