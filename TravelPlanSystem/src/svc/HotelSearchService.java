package svc;

import java.util.ArrayList;

import dao.HotelDAO;
import model.Hotel;

public class HotelSearchService {

	public ArrayList<Hotel> run(String cityName) {
		
		HotelDAO dao = new HotelDAO();
		ArrayList<Hotel> hotelList = dao.getCityHotel(cityName);
		
		return hotelList;
	}

}
