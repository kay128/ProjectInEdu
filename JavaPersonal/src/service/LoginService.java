package service;

import dbDAO.Dao;
import model.Member;

public class LoginService {
	Dao mDao = new Dao();
	
	public Member logSer(Member logMember) {
		Member inMember = mDao.logIn(logMember);
		return inMember;
	}

}
