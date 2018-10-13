package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;

public class LogoutAction implements Action{


	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			ActionForward af = new ActionForward();
			HttpSession session = request.getSession();
			session.removeAttribute("loginUser");
			
			af.setRedirect(true);
			af.setResUrl("index.jsp");
			return af;
	}
}

