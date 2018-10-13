package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import dao.CustomerDAO;
import model.Customer;

public class LoginAction implements Action {


	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward af;
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		String password = request.getParameter("pass");

		CustomerDAO dao = new CustomerDAO();
		Customer cs = dao.loginCheck(email, password);
		
		if(cs != null) {
			session.setAttribute("loginUser", cs);
			af = new ActionForward("/TravelPlanSystem/index.jsp", true);
		}else {
			af = new ActionForward("/login.jsp", false);
			request.setAttribute("message", "ログインに失敗しました。メールアドレスまたはパスワードを確認してください。");
		}
		return af;
	}
}
