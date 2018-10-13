package action;

import java.io.File;
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
import controller.ActionForward;
public class AdminHotelModiAddAction implements Action {

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
		int hotelPrice = Integer.parseInt(multi.getParameter("hotelPrice"));
		int quality = Integer.parseInt(multi.getParameter("quality"));
		String pictureUrl = multi.getFilesystemName("pictureUrl");
		
		System.out.println("되나?");
		
		Hotel hotel = new Hotel();
		String saveDir = "C:/web_it/27기/3. 팀프로젝트(jsp, servlet)/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/TravelPlanSystem/images";
		String fullFileName = saveDir+"/"+hotelName+".jpg";
		java.io.File f0 = new java.io.File(fullFileName);
		if(pictureUrl!=null && f0.exists()) {
			//File f = new File(saveDir+"/"+pictureUrl);
			f0.delete();
			System.out.println("사진 삭제완료");
		}else {
			System.out.println(f0.getName()+"파일이 존재하지 않습니다.");
		}
		
		hotel.setHotelName(hotelName);
		hotel.setHotelCity(hotelCity);
		hotel.setHotelAddress(hotelAddress);
		hotel.setHotelPrice(hotelPrice);
		hotel.setQuality(quality);
		hotel.setPictureUrl(pictureUrl);
		
		String saveDirr = "C:/web_it/27기/3. 팀프로젝트(jsp, servlet)/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/TravelPlanSystem/images";
		String fullFileNamee = saveDirr+"/"+pictureUrl;
		java.io.File f1 = new java.io.File(fullFileNamee);
		if(f1.exists()) {
			File f = new File(saveDirr+"/"+pictureUrl);
			File t = new File(saveDirr+"/"+hotelName+".jpg");
			f.renameTo(t);
			System.out.println("사진 이름바꾸기 완료");
		}else {
			System.out.println(f1.getName()+"파일이 존재하지 않습니다.");
		}
		
		
		HotelDAO modifyHotel = new HotelDAO();
		int result = modifyHotel.modifyHotel(hotel);
		
		if(result>0) {
			System.out.println("hotel	modify success");
		}else {
			System.out.println("hotel modify fail");
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
