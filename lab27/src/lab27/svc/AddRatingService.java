package lab27.svc;

import static lab27.db.JdbcUtils.*;
import java.sql.Connection;

import lab27.vo.LabCompanyDAO;
import lab27.vo.RatingVO;

public class AddRatingService {

	public boolean addRating(RatingVO rating) {
		Connection conn = getConnection();
		LabCompanyDAO dao = new LabCompanyDAO();
		int result = 0;
		
		try {
		result = dao.addRating(rating, conn);
			commit(conn);
		}catch(Exception e){
			e.printStackTrace();
			rollback(conn);
		}finally {
			close(conn, null, null);
		}
	
		
		return result>0? true:false;
	}

}
