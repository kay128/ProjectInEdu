package svc;

import java.util.ArrayList;

import dao.ResultDAO;
import model.Result;

public class ScheduleDeleteService {

	public boolean deleteScheduleByTitle(String title, String email) {
		ArrayList<Result> list = new ArrayList<Result>();
		
		ResultDAO dao = new ResultDAO();
		
		int result = dao.deletescheduleByTitle(title, email);
		
		if(result>0) {
			return true;
		}
		return false;
	}

}
