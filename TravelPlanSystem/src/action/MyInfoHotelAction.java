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
import svc.MyInfoHotelService;

public class MyInfoHotelAction implements Action {


	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer loginUser = (Customer)session.getAttribute("loginUser");
		String email = loginUser.getEmail();
		ActionForward af;
		MyInfoHotelService svc = new MyInfoHotelService();
		ArrayList<Result> myHotelList = svc.run(email);
		System.out.println("myHotelList 크기: " + myHotelList.size());
		if(myHotelList != null) {
			af =  new ActionForward("/myinfo_hotel.jsp", false);
			request.setAttribute("myHotelList", myHotelList);
		}else {
			af = new ActionForward("/myinfo_hotel.jsp", false);
			request.setAttribute("message", "予約したホテル情報を確認できません。");
		}
		
		return af;
	}

}

