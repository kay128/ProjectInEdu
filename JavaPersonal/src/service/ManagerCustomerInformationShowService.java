package service;

import java.util.ArrayList;

import dbDAO.Dao;
import model.Member;

public class ManagerCustomerInformationShowService {
	Dao mDao = new Dao();
	
	public ArrayList<Member> mSearch(String key, String word) {
		
		ArrayList<Member> list = new ArrayList<Member>();
		list = mDao.searchMember(key, word);
		
		return list;
	}

}
