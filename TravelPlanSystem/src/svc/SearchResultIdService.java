package svc;

import java.util.ArrayList;

import dao.HotelDAO;
import model.Result;

public class SearchResultIdService {

	public int run(Result bookingInfo) {
		HotelDAO dao = new HotelDAO();
		int resultId = dao.getResultId(bookingInfo);
		return resultId;
	}
	
}
