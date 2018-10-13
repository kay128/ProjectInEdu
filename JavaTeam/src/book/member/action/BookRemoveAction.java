package book.member.action;

import java.util.ArrayList;
import java.util.Scanner;


import book.member.dto.Book;
import book.member.svc.BookEnterService;
import book.member.svc.BookRemoveService;
import book.member.svc.BookSearchService;
import book.member.ui.MainProcessor;
import book.member.util.ConsoleUtils;

public class BookRemoveAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		ConsoleUtils cu = new ConsoleUtils();
		Book book = null;
		ArrayList<Book> list =null;
		
		
		BookSearchService searchservice = new BookSearchService();

		String name = cu.getName("삭제", sc);// 콘솔을 통해 메뉴 출력 + 도서 제목 검색 = 도서 검색이 자주 사용될 것이기 때문에 문구가 변경되도록 설정
		list = searchservice.getBook(name); // 입력받은 책 제목을 service로 보냄. > service가 DB에서 받아온 book을 저장

		if (list.size()==0) { // 책 이름으로 책 정보를 받아오지 못한다면
			cu.searchFail(name); // 실패 문 출력
		} else { // 책 이름과 동일한 책이 존재한다면
			cu.show(list); // 콘솔 - 책 정보 출력
			
			book = cu.buyChoice("삭제",sc, list);
			
			
			BookRemoveService removeservice=new BookRemoveService();
			
			boolean isUpdate = removeservice.removeBook(book);
			if(isUpdate) {
				cu.showRemoveSuccess();
			}else {
				cu.showRemoveFail();
			}

		}

	}
}


