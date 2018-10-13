package service;

import dbDAO.Dao;
import model.Query;

public class CodingDropService {
	
	Dao mDao = new Dao();
	public boolean coDrop(Query choicedQuery) {
		boolean result = false;
		int record = 0;
		record = mDao.codingDrop(choicedQuery);
		switch(record) {
		case 1:
			result = true;
			break;
		case 2:
			result = false;
			break;
		}
		return result;
	}

}
