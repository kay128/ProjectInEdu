package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import controller.ActionForward;
import model.Customer;
import svc.ScheduleService;

public class CreateScheduleAction implements Action {


	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String title = request.getParameter("scheduletitle");
		System.out.println(title);
		String schedule = request.getParameter("schedule_arr");
		System.out.println(schedule);
		String schedule_lastday = request.getParameter("schedule_lastday");
		System.out.println(schedule_lastday);
		
		HttpSession session = request.getSession();
		Customer customer = (Customer)session.getAttribute("loginUser");
		//String email = customer.getEmail();
		
		ScheduleService svc = new ScheduleService();
		boolean result = svc.createschedule(title,schedule,schedule_lastday,customer);
		
		
		
		try {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObj = (JSONObject)jsonParser.parse(schedule);
			JSONArray array = (JSONArray)jsonObj.get("plan");
			
			for(int i=0;i<array.size();i++) {
				JSONObject tempObj = (JSONObject) array.get(i);
				System.out.println(""+(i+1)+"번째 day : "+tempObj.get("day").toString());
				System.out.println(""+(i+1)+"번째 place : "+tempObj.get("place").toString());
				System.out.println("----------------------------");
			}
		}catch(ParseException e) {
			e.printStackTrace();
		}

		ActionForward af = null;
		
		af = new ActionForward("create_schedule.jsp",true);


		return af;
	}

}

