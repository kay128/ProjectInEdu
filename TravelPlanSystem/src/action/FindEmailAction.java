package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import dao.CustomerDAO;

public class FindEmailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward af;
		response.setContentType("text/html; charset = utf-8");
		
		String email = null;
		String nickName = null;
		
		nickName = request.getParameter("nickName");
		CustomerDAO dao = new CustomerDAO();
		email = dao.findEmail(nickName);
		
		if(email != null) {
			af = new ActionForward("/find.jsp", false);
			request.setAttribute("message", "メールアドレスは "+email+"です。");
		}else {
			af = new ActionForward("/find.jsp", false);
			request.setAttribute("message2", "該当するニックネーム情報を確認できません。");
		}
		return af;
	}

}
