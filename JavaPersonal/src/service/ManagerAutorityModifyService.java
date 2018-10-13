package service;

import dbDAO.Dao;
import model.Member;

public class ManagerAutorityModifyService {
	Dao mDao = new Dao();
	public boolean cAutority(Member afterMember) {
		boolean result = false;
		int record = 0;
		record = mDao.cAutority(afterMember);
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
