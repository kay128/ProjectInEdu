package svc;

import dao.HotelDAO;
import model.Result;

public class BookingInfoService {

	public Result run(int resultId) {
		HotelDAO dao = new HotelDAO();
		Result bookingInfo = dao.getBookingInfo(resultId);
		
		return bookingInfo;
	}

}
