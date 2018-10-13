package svc;

import java.util.ArrayList;

import dao.ResultDAO;
import model.Result;

public class MyinfoService {

	public ArrayList<Result> getCustomerSchedule(String email) {
		ResultDAO dao = new ResultDAO();
		ArrayList<Result> list = new ArrayList<Result>();
		list =dao.getCustomerSchedule(email);
		
		return list;
	}

}
