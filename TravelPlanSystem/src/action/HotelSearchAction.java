package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import model.Hotel;
import svc.HotelSearchService;
public class HotelSearchAction implements Action {


	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cityName = request.getParameter("cityName");
		String checkIn = request.getParameter("checkIn");
		String checkOut = request.getParameter("checkOut");
		ActionForward af;
		HotelSearchService svc = new HotelSearchService();
		System.out.println("입력한 도시 명: "+cityName);
		ArrayList<Hotel> hotelList = svc.run(cityName);
		System.out.println("호텔리스트 사이즈:"+ hotelList.size());
		
		
		if(hotelList.size() == 0){
			af = new ActionForward("hotel_search.jsp", false);
			request.setAttribute("message", "検索した地域のホテル情報を確認できません。");
		}else {
			af =  new ActionForward("hotel_search.jsp", false);
			request.setAttribute("hotelList", hotelList);
			request.setAttribute("checkIn", checkIn);
			request.setAttribute("checkOut", checkOut);
		}
		
		return af;
	}

}
