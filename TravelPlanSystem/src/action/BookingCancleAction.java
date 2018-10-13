package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.Customer;
import model.Result;
import svc.BookingCancleService;
import svc.HotelBookingService;

public class BookingCancleAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer loginUser = (Customer)session.getAttribute("loginUser");
		int resultId = Integer.parseInt(request.getParameter("resultId"));
		
		System.out.println("취소 대상 결과 번호" +resultId);
		ActionForward af;
		BookingCancleService svc = new BookingCancleService();
		
		int result = svc.run(loginUser, resultId);
		
		if(result > 0) {
			af =  new ActionForward("myinfo_hotelbooking.do", false);
			request.setAttribute("email", loginUser.getEmail());
			request.setAttribute("message", "ホテルの予約をキャンセルしました。");
		}else {
			af =  new ActionForward("myinfo_hotelbooking.do", false);
			request.setAttribute("message", "予約キャンセルに失敗しました。");
		}
		
		return af;
	}

}
