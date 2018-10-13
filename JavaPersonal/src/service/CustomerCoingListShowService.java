package service;

import java.util.ArrayList;

import dbDAO.Dao;
import model.Query;
import model.Member;

public class CustomerCoingListShowService {

	public ArrayList<Query> getList(Member inMember) {
		Dao dao = new Dao();
		ArrayList<Query> list = dao.getList(inMember);
	
		return list;
	}

}
