package book.member.svc;

import java.util.ArrayList;

import book.member.dao.BookDAO;
import book.member.dto.Book;

public class TotalMoneyService {

	public ArrayList<Book> allMoney() {
		ArrayList<Book> list =null;//전체 db 데이터를 가져 올것 이기 때문에 arrylist 선언
		
		BookDAO dao=new BookDAO();//쿼리는 처리 하는 클래스
		list=dao.selectAllMember();//모든 데이터 를 가져오는 쿼리는 처리 하는 함수ㄴ
	
		return list;
	}

}
