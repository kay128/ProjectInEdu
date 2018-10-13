package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.Customer;
import model.Result;
import svc.HotelBookingService;

public class HotelBookingAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		ActionForward af;
		System.out.println("실행 test 시점 1");
		Customer loginUser = (Customer)session.getAttribute("loginUser");
		
		Result bookingInfo = new Result(0, loginUser.getEmail(), 
				loginUser.getNickName(),
				"sysdate", request.getParameter("hotelName"),
				request.getParameter("checkIn"), 
				request.getParameter("checkOut"), 0);
		
	
		HotelBookingService svc = new HotelBookingService();
		int resultId = svc.run(bookingInfo);
		
		if(resultId > 0) {
			af =  new ActionForward("bookingInfo.do", false);
			request.setAttribute("bookingInfo", bookingInfo);
		}else {
			af = new ActionForward("hotel_select.do", false);
			request.setAttribute("message", "ホテルの予約に失敗しました。");
		}
		
		return af;
	}

}
