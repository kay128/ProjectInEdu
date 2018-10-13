package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.Customer;
import model.Result;
import svc.BookingInfoService;
import svc.SearchResultIdService;

public class BookingInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward af;
		int resultId = -1;
		
		try {
			resultId = Integer.parseInt(request.getParameter("resultId"));
		}catch(NumberFormatException e) {
			Result bookingInfo1 = (Result)request.getAttribute("bookingInfo");
			SearchResultIdService svc1 = new SearchResultIdService();
			resultId = svc1.run(bookingInfo1);
		}
		

		System.out.println("넘어온 결과Id는?"+resultId);
		BookingInfoService svc = new BookingInfoService();
		Result bookingInfo = svc.run(resultId);
		
		
		if(bookingInfo.getResultId() > -1) {
			System.out.println("info받아왔지롱");
			af = new ActionForward("myinfo_hotel.jsp", false);
			request.setAttribute("bookingInfo", bookingInfo);
			if(request.getAttribute("message")!=null) {
				request.setAttribute("message", request.getAttribute("message"));
			}
		}else {
			af = new ActionForward("myinfo_hotelbooking.do", false);
		}
		return af;
	}

}
