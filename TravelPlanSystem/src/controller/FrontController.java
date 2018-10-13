package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.AdminAction;
import action.AdminHotelAction;
import action.AdminHotelAddAction;
import action.AdminHotelDeleteAction;
import action.AdminHotelModiAddAction;
import action.AdminHotelModifyAction;
import action.BoardDeleteAction;
import action.BoardModifyAction;
import action.BoardReplyAction;
import action.BoardshowAction;
import action.BoardviewAction;
import action.BoardwriteAction;
import action.BookingCancleAction;
import action.BookingInfoAction;
import action.CreateScheduleAction;
import action.FindEmailAction;
import action.FindPassAction;
import action.HotelAction;
import action.HotelBookingAction;
import action.HotelReviewAction;
import action.HotelSearchAction;
import action.HotelSelectAction;
import action.LoginAction;
import action.LogoutAction;
import action.MyInfoAction;
import action.MyInfoHotelAction;
import action.MyInfoHotelBooking;
import action.RegisterAction;
import action.RemoveAction;
import action.SchcheduleDeleteAction;
import action.ScheduleDetailAction;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FrontController() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; character=utf-8");
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length());
		
		Action action = null;
		ActionForward af = null;
		
		System.out.println("전달된 command:"+command);
		
		if(command.equals("/login.do")) {
			action = new LoginAction();
		}else if(command.equals("/register.do")) {
			action = new RegisterAction();
		}else if(command.equals("/create_schedule.do")) {
			action = new CreateScheduleAction();
		}else if(command.equals("/schedule_detail.do")) {
			action = new ScheduleDetailAction();
		}else if(command.equals("/myinfo_scheduledelete.do")) {
			System.out.println("스케쥴 delete");
			action = new SchcheduleDeleteAction();
		}else if(command.equals("/hotel.do")) {
			action = new HotelAction();
		}else if(command.equals("/hotel_search.do")) {
			action = new HotelSearchAction();
		}else if(command.equals("/hotel_select.do")) {
			action = new HotelSelectAction();
		}else if(command.equals("/hotel_booking.do")) {
			action = new HotelBookingAction();
		}else if(command.equals("/myinfo.do")) {
			action = new MyInfoAction();	
		}else if(command.equals("/myinfo_hotelbooking.do")) {
			System.out.println("myinfo_hotelbooking");
			action = new MyInfoHotelBooking();
		}else if(command.equals("/myinfo_hotel.do")) {
			action = new MyInfoHotelAction();
		}else if(command.equals("/hotel_review.do")) {
			action = new HotelReviewAction();
		}else if(command.equals("/admin.do")) {
			action = new AdminAction();
		}else if(command.equals("/admin_hotel.do")) {
			action = new AdminHotelAction();
		}else if(command.equals("/admin_hotel_add.do")) {
			action = new AdminHotelAddAction();
		}else if(command.equals("/admin_hotel_modify.do")) {
			action = new AdminHotelModifyAction();
		}else if(command.equals("/admin_hotel_modiadd.do")){
			action = new AdminHotelModiAddAction();
		}else if(command.equals("/admin_hotel_delete.do")) {
			action = new AdminHotelDeleteAction();
		}else if(command.equals("/logout.do")) {
			action = new LogoutAction();
		}else if(command.equals("/remove.do")){
			action = new RemoveAction();
		}else if(command.equals("/findemail.do")) {
			action = new FindEmailAction();
		}else if(command.equals("/findpass.do")) {
			action = new FindPassAction();
		}else if(command.equals("/bookingCancle.do")) {
			action = new BookingCancleAction();
		}else if(command.equals("/bookingInfo.do")) {
			action = new BookingInfoAction();
		}else if(command.equals("/boardview.do")) {
			action = new BoardviewAction();
		}else if(command.equals("/boardWrite.do")) {
			action = new BoardwriteAction();
		}else if(command.equals("/boardshow.do")) {
			action = new BoardshowAction();
		}else if(command.equals("/boardmodify.do")) {
			System.out.println("board modify");
			action = new BoardModifyAction();
		}else if(command.equals("/boarddelete.do")) {
			System.out.println("board delete");
			action = new BoardDeleteAction();
		}else if(command.equals("/board_reply.do")) {
			System.out.println("board reply");
			action = new BoardReplyAction();
		}
		
		try {
			if(action != null) {
				af = action.execute(request, response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

		
		if(af != null) {
			if(af.isRedirect()) {
				response.sendRedirect(af.getResUrl());
			}else{
				RequestDispatcher rdp = request.getRequestDispatcher(af.getResUrl());
				rdp.forward(request, response);
			}
		}
	
	}

}
