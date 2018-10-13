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
import svc.MyinfoHotelBookingService;

public class MyInfoHotelBooking implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Result> hotellist = new ArrayList<Result>();
		HttpSession session = request.getSession();
		Customer customer = (Customer)session.getAttribute("loginUser");
		
		//System.out.println(customer.getEmail());
		System.out.println("MyHotelInfo:Action");
		String email = customer.getEmail();
		MyinfoHotelBookingService svc = new MyinfoHotelBookingService();
		//svc.getMyHotelList(email);
		
		hotellist = svc.getMyHotelBookingList(email);
		
		for(int i=0; i<hotellist.size(); i++) {
			System.out.println(hotellist.get(i).getHotelName());
		}
		
		ActionForward af = null;
		
		request.setAttribute("hotelbookinglist", hotellist);
		
		af=new ActionForward("myinfo_hotelbookinglist.jsp", false);				
		return af;
	}

}
