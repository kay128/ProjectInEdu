package svc;

import java.util.ArrayList;

import dao.ResultDAO;
import model.Customer;
import model.Result;

public class ScheduleDetailService {

	public ArrayList<Result> getSchedule(String title, String email) {
		ArrayList<Result> list = new ArrayList<Result>();
		
		ResultDAO dao = new ResultDAO();
		list = dao.getScheduleDetail(title,email);
		
		return list;
	}

}
