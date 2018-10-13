package svc;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import dao.ResultDAO;
import model.Customer;

public class ScheduleService {

	public boolean createschedule(String title, String schedule, String lastday, Customer customer) {
		
		JSONArray array = null;
		
		try {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObj = (JSONObject)jsonParser.parse(schedule);
			array = (JSONArray)jsonObj.get("plan");
			
			for(int i=0;i<array.size();i++) {
				JSONObject tempObj = (JSONObject) array.get(i);
				System.out.println(""+(i+1)+"번째 day : "+tempObj.get("day"));
				System.out.println(""+(i+1)+"번째 place : "+tempObj.get("place"));
				System.out.println("----------------------------");
			}
		}catch(ParseException e) {
			e.printStackTrace();
		}

		
		ResultDAO dao = new ResultDAO();
		int result = dao.createSchedule(title, array, lastday, customer);
		
		if(result>0) {
			System.out.println("스케쥴 저장에 성공하엿습니다.");
			return true;
		}else {
			System.out.println("스케쥴 저장에 실패하였습니다.");
			return false;
		}
		
	}

}
