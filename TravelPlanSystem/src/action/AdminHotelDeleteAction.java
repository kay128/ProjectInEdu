package action;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import dao.HotelDAO;
import model.Hotel;
import svc.AdminService;
import svc.HotelSelectService;
import controller.ActionForward;

public class AdminHotelDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String hotelName = request.getParameter("hotelName");

		HotelDAO deletehotel = new HotelDAO();
		int result = deletehotel.deleteHotel(hotelName);
		if(result>0) {
			
			ArrayList <Hotel> hotellist = new ArrayList <Hotel>();
			
			AdminService svc = new AdminService();
			hotellist =svc.gethotellist();
			
			
			request.setAttribute("hotellist",hotellist);
			System.out.println("hotel delete success");
		}else {
			System.out.println("hotel delete fail");
		}
		ActionForward af = null;
		

		
		af=new ActionForward("admin_hotel.jsp",false);
		return af;
		
	}
}
		
