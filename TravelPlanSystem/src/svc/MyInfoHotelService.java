package svc;

import java.util.ArrayList;

import dao.HotelDAO;
import model.Result;

public class MyInfoHotelService {

	public ArrayList<Result> run(String email) {
		HotelDAO dao = new HotelDAO();
		ArrayList<Result> myHotelList = dao.myInfoHotel(email);
		
		return myHotelList;
	}

}
