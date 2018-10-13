package book.member.svc;

import java.util.ArrayList;

import book.member.dao.BookDAO;
import book.member.dto.Book;

/* Action에서 책 제목 받아오기.
   책 제목, 구매수량 DAO에 전달하기
   
   DAO 처리 결과를 action 에게 전달
   [정보 출력 + 구매 입력 결과]
  */
public class BookBuyService {
	public ArrayList<Book> getBook(String name) { // 책 제목으로 정보 가져오는 메서드
		BookDAO dao = new BookDAO(); // SQL문 연결
		ArrayList<Book> list = dao.selectOnebook(name); // DB에서 한개의 책 정보를 받아옴
		return list;
	}

	public boolean buyBook(ArrayList<Book> buyList) { // 책 구매 메서드
		int updateCount = 0;
		BookDAO dao = new BookDAO(); //DB - sql 실행 연결
		updateCount = dao.buyBook(buyList); // 콘솔 - action을 거쳐 넘겨받은 list를 DB 반영 메소드로 연결 > 업데이트 완료 시 결과값 != 0
		
		if(updateCount == 0) { // DB 반영 실패시 false 리턴
			return false;
		}else { // DB 반영 성공시 true 리턴 >> action으로
			return true;
		}
		
	}
}
