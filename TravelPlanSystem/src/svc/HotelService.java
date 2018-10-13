package svc;

import java.util.ArrayList;

import dao.HotelDAO;
import model.Hotel;

public class HotelService {

	public ArrayList<Hotel> run() {
		HotelDAO dao = new HotelDAO();
		System.out.println("서비스 활동 여부 체크 - 전");
		ArrayList<Hotel> randomList = dao.getRandomHotel();
		System.out.println("서비스 활동 여부 체크 " + randomList.size());
		return randomList;
	}
	
}
