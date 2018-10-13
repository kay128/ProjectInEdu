package service;

import dbDAO.Dao;
import model.Member;

public class IdentifiedService {
	Dao mDao = new Dao();
	public Member infoMember(Member identifiedMember) {
		Member infoMember = mDao.infoMember(identifiedMember);
		
		return infoMember;
	}

}
