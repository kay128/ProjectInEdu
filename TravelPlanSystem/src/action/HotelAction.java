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
import svc.HotelService;

public class HotelAction implements Action {


	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ActionForward af;
		HotelService svc = new HotelService();
		System.out.println("action 활동 여부 체크 - 전");
		ArrayList<Hotel> randomList = svc.run();
		
		if(randomList != null) {
			System.out.println("action 받아온 목록 크기?" + randomList.size());
			request.setAttribute("randomList", randomList);
			af =  new ActionForward("/hotel.jsp", false);
		}else {
			request.setAttribute("message", "遊び組みのオススメを確認できません。");
			af = new ActionForward("/hotel.jsp", false);
		}
		
		return af;
	}

}
