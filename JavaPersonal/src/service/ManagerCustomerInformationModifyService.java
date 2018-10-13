package service;

import dbDAO.Dao;
import model.Member;

public class ManagerCustomerInformationModifyService {

	Dao mDao = new Dao();
	public boolean cModify(Member afterMember) {
		boolean result = false;
		int record = 0;
		record = mDao.cModify(afterMember);
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
