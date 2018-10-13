package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.Customer;
import model.Result;
import svc.MyinfoService;

public class MyInfoAction implements Action {


	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer customer = (Customer)session.getAttribute("loginUser");
		//System.out.println(customer.getEmail());
		MyinfoService svc = new MyinfoService();
		
		String email = customer.getEmail();
		System.out.println(email);
		ArrayList<Result> list = new ArrayList<Result>();
		list = svc.getCustomerSchedule(email);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		
		ActionForward af = null;
		
		request.setAttribute("schedulelist", list);
		
		af=new ActionForward("myinfo.jsp",false);
		return af;
	}

}

