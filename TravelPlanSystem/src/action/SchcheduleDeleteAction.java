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
import svc.ScheduleDeleteService;

public class SchcheduleDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<Result> list = new ArrayList<Result>(); 
		
		HttpSession session = request.getSession();
		Customer customer = (Customer)session.getAttribute("loginUser");
		
		String title = request.getParameter("scheduleTitle");
		String email = customer.getEmail();
		System.out.println("delte: "+ title);
		
		ScheduleDeleteService svc = new ScheduleDeleteService();
		boolean result = svc.deleteScheduleByTitle(title,email);
		
		ActionForward af = null;
		
		if(result) {
			
			MyinfoService myinfosvc = new MyinfoService();
			list = myinfosvc.getCustomerSchedule(email);
			
			request.setAttribute("schedulelist", list);
			af = new ActionForward("myinfo.jsp",false);
			
		}
		
		return af;
	}

}
