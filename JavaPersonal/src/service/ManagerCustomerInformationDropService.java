package service;

import dbDAO.Dao;
import model.Member;

public class ManagerCustomerInformationDropService {
	Dao mDao = new Dao();
	public boolean cDrop(Member modifyMember) {
		boolean result = false;
		int record = 0;
		record = mDao.cDrop(modifyMember);
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
