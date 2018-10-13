package svc;

import dao.HotelDAO;
import model.Result;

public class HotelBookingService {

	public int run(Result bookingInfo) {
		HotelDAO dao = new HotelDAO();
		int result = dao.bookingHotel(bookingInfo);
		if(result != 0) {
			HotelDAO dao1 = new HotelDAO();
			int resultId = dao1.getResultId(bookingInfo);
			return resultId;
		}else {
			return -1;
		}		
	}

}
