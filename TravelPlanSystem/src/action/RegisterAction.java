package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import dao.CustomerDAO;
import model.Customer;

public class RegisterAction implements Action {


	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ActionForward af;
		response.setContentType("text/html; charset = utf-8");
		
		boolean eCheck = false;
		boolean nCheck = false;
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String nickName = request.getParameter("nickName");
		
		Customer cs = new Customer(email, pass, nickName);
		CustomerDAO dao = new CustomerDAO();
		eCheck = dao.emailCheck(email);
		CustomerDAO dao2 = new CustomerDAO();
		nCheck = dao2.nickNameCheck(nickName);
		CustomerDAO dao3 = new CustomerDAO();
		
		
		
		if(eCheck == false || nCheck == false) {
			af = new ActionForward("/register.jsp", false);
			request.setAttribute("message2", "会員登録に失敗しました。メールアドレスまたはニックネームの重複を確認してください。");
		}else {
			dao3.insertCustomer(cs);
			af = new ActionForward("/index.jsp", false);
			request.setAttribute("message2", "会員登録に成功しました。メインページへ移動します。");
		}		
		return af;
	}

}
