package service;

import dbDAO.Dao;
import model.Query;

public class CustomerCoingLoadService {

	public boolean setQuery(Query makedQuery) {
		Dao dao = new Dao();
		boolean result = false;
		int count = dao.setQuery(makedQuery);
		
		if(count == 0) {
			result = false;
		}else {
			result = true;
		}
		
		return result;
		
	}

}