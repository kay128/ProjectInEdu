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
public class AdminHotelModifyAction implements Action {


	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

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
			af =  new ActionForward("/admin_hotel_modify.jsp", false);
			request.setAttribute("selectedHotel", selectedHotel);
		}else {
			af = new ActionForward("/hotel_select.jsp", false);
						request.setAttribute("message", "該当するホテル情報を確認できません。");
					}
					
					return af;
				}
				}