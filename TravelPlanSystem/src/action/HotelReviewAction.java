package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.ActionForward;
import model.Customer;
import model.Hotel;
import model.Result;
import svc.HotelReviewService;
import svc.HotelSearchService;
import svc.MyInfoHotelService;

public class HotelReviewAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("리뷰 등록창 입니다.");
		int resultId = Integer.parseInt(request.getParameter("resultId"));
		String hotelName = request.getParameter("hotelName");
		int reviewGrade = Integer.parseInt(request.getParameter("reviewGrade"));
		String reviewContent = request.getParameter("reviewContent");
		Result reivew = new Result(resultId, hotelName, reviewGrade,
				reviewContent);
		
		System.out.println("값 확인하기 + 결과id "+resultId);
		System.out.println("값 확인하기 + 호텔이름 "+hotelName);
		System.out.println("값 확인하기 + 평점" + reviewGrade);
		System.out.println("값 확인하기 + 입력내용" + reviewContent);

		
		HotelReviewService svc2 = new HotelReviewService();
		ActionForward af;
		int result = svc2.run(reivew);
		if(result == 1) {
			System.out.println("리뷰까지 썻다잉");
			af = new ActionForward("bookingInfo.do", false);
			request.setAttribute("message", "クチコミ登録に成功しました。");
			return af;
		}else {
			af = new ActionForward("hotel_select.do", false);
			request.setAttribute("message", "クチコミ登録に失敗しました。");
			return af;
		}
		
	}
	
}