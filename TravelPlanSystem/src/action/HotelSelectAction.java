package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import model.Hotel;
import svc.HotelSelectService;

public class HotelSelectAction implements Action {


	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String hotelName = request.getParameter("hotelName");
		if(request.getParameter("checkIn")!= null) {
			String checkIn = request.getParameter("checkIn");
			String checkOut = request.getParameter("checkOut");
			request.setAttribute("checkIn", checkIn);
			request.setAttribute("checkOut", checkOut);
			
		}
		ActionForward af;
		System.out.println("선택한 호텔 이름 " + hotelName);
		HotelSelectService svc = new HotelSelectService();
		ArrayList<Hotel> selectedHotel = svc.run(hotelName);
		
		if(selectedHotel != null) {
			af =  new ActionForward("/hotel_select.jsp", false);
			if(request.getAttribute("message") != null){
				System.out.println("message 넘어왔음");
				request.setAttribute("message", request.getAttribute("message"));
			}
			request.setAttribute("selectedHotel", selectedHotel);
		}else {
			af = new ActionForward("/hotel_select.jsp", false);
			request.setAttribute("message", "該当するホテル情報を確認できません。");
		}
		
		return af;
		

	}

}
