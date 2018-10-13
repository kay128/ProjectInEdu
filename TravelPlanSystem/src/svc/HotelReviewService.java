package svc;


import dao.HotelDAO;
import model.Result;

public class HotelReviewService {

	public int run(Result review) {
		
		HotelDAO dao = new HotelDAO();
		int result1 = dao.writeReview(review);
		HotelDAO dao2 = new HotelDAO();
		int result2 = dao2.updateReview(review.getHotelName());
		
		if(result1 > 0 && result2 > 0) {
			return 1;
		}else {
			return 2;
		}
	}

}
