package svc;


import java.util.ArrayList;

import dao.HotelDAO;
import model.Hotel;

public class HotelSelectService {

	public ArrayList<Hotel> run(String hotelName) {
		HotelDAO dao = new HotelDAO();
		ArrayList<Hotel> selectedHotel = dao.selectHotel(hotelName);
		
		return selectedHotel;
	}

}
