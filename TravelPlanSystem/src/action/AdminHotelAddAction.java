package action;

import java.io.IOException;
import java.util.ArrayList;
import java.io.File;
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
import controller.ActionForward;
public class AdminHotelAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("images");
		String encType = "UTF-8";
		int sizeLimit = 20 * 1024 * 1024;
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
		
		String hotelName = multi.getParameter("hotelName");
		String hotelCity = multi.getParameter("hotelCity");
		String hotelAddress = multi.getParameter("hotelAddress");
		String hotelPrice = multi.getParameter("hotelPrice");
		String quality = multi.getParameter("quality");
		String pictureUrl = multi.getFilesystemName("pictureUrl");
	
		System.out.println("되나?");
		Hotel hotel = new Hotel();
		hotel.setHotelName(hotelName);
		hotel.setHotelCity(hotelCity);
		hotel.setHotelAddress(hotelAddress);
		hotel.setHotelPrice(Integer.parseInt(hotelPrice));
		hotel.setQuality(Integer.parseInt(quality));
		hotel.setPictureUrl(pictureUrl);
		
		System.out.println(pictureUrl);;
		System.out.println(hotelName);
		String saveDir = "C:/web_it/27기/3. 팀프로젝트(jsp, servlet)/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/TravelPlanSystem/images";
		String fullFileName = saveDir+"/"+pictureUrl;
		java.io.File f1 = new java.io.File(fullFileName);
		if(f1.exists()) {
			File f = new File(saveDir+"/"+pictureUrl);
			File t = new File(saveDir+"/"+hotelName+".jpg");
			f.renameTo(t);
			System.out.println("사진 이름바꾸기 완료");
		}else {
			System.out.println(f1.getName()+"파일이 존재하지 않습니다.");
		}
		
		
		
		System.out.println("adminhoteladdaction");
		//사진저장된 경로 : 각자컴퓨터 워크스페이스안에 \.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\TravelPlanSystem\images
		
		
		HotelDAO addHotel = new HotelDAO();
		int result = addHotel.addHotel(hotel);
		
		if(result>0) {
			System.out.println("hotel insert success");
		}else {
			System.out.println("hotel insert fail");
		}
		ActionForward af = null;
		ArrayList <Hotel> hotellist = new ArrayList <Hotel>();
		
		AdminService svc = new AdminService();
		hotellist =svc.gethotellist();
		

		
		request.setAttribute("hotellist",hotellist);
		
		af=new ActionForward("admin_hotel.jsp",false);
		return af;
		
	}

}

