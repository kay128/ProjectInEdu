package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import dao.CustomerDAO;
import model.Customer;

public class RemoveAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward af;
		HttpSession session = request.getSession();
		
		String password = request.getParameter("pass");
		
		Customer loginUser = (Customer)session.getAttribute("loginUser");
		
		
		if(loginUser.getPass().equals(password)) {
			CustomerDAO dao = new CustomerDAO();
			dao.deleteCustomer(loginUser.getEmail());
			session.removeAttribute("loginUser");
			af = new ActionForward("/index.jsp", false);
			request.setAttribute("message", "会員退会に成功しました。");
		}else {
			af = new ActionForward("/remove.jsp", false);
			request.setAttribute("message2", "会員退会に失敗しました。パスワードを確認してください。");
		}
		
		return af;
	}
}
