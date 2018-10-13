package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import svc.AdminService;
import controller.ActionForward;

public class AdminAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//frontcontroller 에서 admin.do를 받아서 adminaction으로 보낸다. 이제 서비스를 만들고
		ArrayList <Customer> customerlist = new ArrayList <Customer>();
		
		AdminService svc = new AdminService();
		customerlist =svc.getcustomerlist();
		
		ActionForward af = null;
		
		request.setAttribute("customerlist",customerlist);

		af=new ActionForward("admin.jsp",false);
		return af;
	}

}


