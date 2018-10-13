package svc;

import dao.HotelDAO;
import model.Customer;

public class BookingCancleService {

	public int run(Customer loginUser, int resultId) {
		HotelDAO dao = new HotelDAO();
		int result = dao.cancleHotel(loginUser, resultId);
		
		return result;
	}
	
}
