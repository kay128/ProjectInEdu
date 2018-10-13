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
import svc.ScheduleDetailService;

public class ScheduleDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<Result> list = new ArrayList<Result>();
		ArrayList<String> day_list = new ArrayList<String>();
		
		String title = request.getParameter("scheduleTitle");
		System.out.println(title);
		
		HttpSession session = request.getSession();
		Customer customer = (Customer)session.getAttribute("loginUser");
		String email = customer.getEmail();
		
		ScheduleDetailService svc = new ScheduleDetailService();
		list = svc.getSchedule(title,email);
		
		System.out.println("lastday: " +list.get(0).getScheduleLastDay());
		
		int lastday = list.get(0).getScheduleLastDay();
		
		ActionForward af = null;

		int length=list.size();
		System.out.println(length);
		String[] dayschedule = new String[lastday+1];
		
		//dayschedule 배열 초기화
		for (int i=1;i<=lastday;i++) {
			dayschedule[i]="";
		}

		//각 visitdate에 맞춰 날짜별 배열 만들기
		for(int i=0;i<length;i++) {

			for(int j=1;j<=lastday;j++) {
				if(list.get(i).getVisitDate()==j) {
					dayschedule[j]+=list.get(i).getPlaceName()+" ";
				}
			}
			
		}
		
		request.setAttribute("title", title);
		
		for(int i=1;i<=lastday;i++) {

			day_list.add(dayschedule[i]);
			System.out.println("dayschedule["+i+"]:"+dayschedule[i]);
		}
		
		request.setAttribute("day_list",day_list);

		
		af = new ActionForward("schedule_detail.jsp",false);
		return af;
	}

}
