package book.member.svc;

import java.util.ArrayList;

import book.member.dao.BookDAO;
import book.member.dto.Book;

public class BookRecommendService {
	public ArrayList<Book> allcount() {
		ArrayList<Book> list =null;//모든 정보를  가저오기 위해서
		
		BookDAO dao=new BookDAO();//쿼리문 처리 하는 클래스
		list=dao.selecRecommend();//판매량을 내림차 순으로 정령하여 데이터를 가져오기위한 커리문 처리 함수
	
		return list;
	}
}
