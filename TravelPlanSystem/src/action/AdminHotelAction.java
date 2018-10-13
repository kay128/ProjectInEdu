package action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ActionForward;
import model.Customer;
import model.Hotel;
import svc.AdminService;

public class AdminHotelAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	ArrayList <Hotel> hotellist = new ArrayList <Hotel>();
		
		AdminService svc = new AdminService();
		hotellist =svc.gethotellist();
		
		ActionForward af = null;
		
		request.setAttribute("hotellist",hotellist);

		af=new ActionForward("admin_hotel.jsp",false);
		return af;
	}


}

