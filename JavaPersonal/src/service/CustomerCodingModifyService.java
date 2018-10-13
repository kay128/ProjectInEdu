package service;

import dbDAO.Dao;
import model.Query;

public class CustomerCodingModifyService {
	
	Dao mDao = new Dao();
	public boolean modifyCoding(Query afterQuery) {
		boolean result = false;
		int record = 0;
		record = mDao.qModify(afterQuery);
		if(record != 0) {
			result = true;
		}else if(record == 0) {
			result = false;
		}
		return result;
	}

}
