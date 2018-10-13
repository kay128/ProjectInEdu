package service;

import dbDAO.Dao;
import model.Member;

public class JoinService {
	
	public String idCheck(String joinId) {
		Dao mDao = new Dao();
		String id = mDao.joinId(joinId);	
		return id;
	}

	public boolean join(Member joinMember) {
		Dao mDao = new Dao();
		int record = mDao.join(joinMember);
		boolean result = false;
		if(record>0) {
			result = true;
		}else if(record == 0){
			result = false;
		}
		return result;
	}

}
