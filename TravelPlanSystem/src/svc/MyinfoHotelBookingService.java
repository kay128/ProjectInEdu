package svc;

import java.util.ArrayList;

import dao.ResultDAO;
import model.Result;

public class MyinfoHotelBookingService {

	public ArrayList<Result> getMyHotelBookingList(String email) {
		System.out.println("MyHotelInto:service");
		ArrayList<Result> hotellist = new ArrayList<Result>();
		ResultDAO dao = new ResultDAO();
		hotellist = dao.getMyHotelBookingList(email);
		
		return hotellist;
	}

}
