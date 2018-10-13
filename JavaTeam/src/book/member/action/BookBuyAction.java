package book.member.action;

import java.util.ArrayList;
import java.util.Scanner;

import book.member.dto.Book;
import book.member.svc.BookBuyService;
import book.member.util.ConsoleUtils;

public class BookBuyAction implements Action { // 도서 구매 action

	public void execute(Scanner sc) throws Exception {
		int choice = 0;
		Book book = null;
		Book bookResult = null;
		ConsoleUtils con = new ConsoleUtils();
		BookBuyService bbser = new BookBuyService(); // 도서 구매 service 연결
		ArrayList<Book> list = new ArrayList<Book>();
		ArrayList<Book> buyList = new ArrayList<Book>();

		do {
			String name = con.getName("구매", sc);// 콘솔을 통해 메뉴 출력 + 도서 제목 검색 = 도서 검색이 자주 사용될 것이기 때문에 문구가 변경되도록 설정
			list = bbser.getBook(name); // 입력받은 책 제목을 service로 보냄. > service가 DB에서 받아온 book을 저장

			if (list.size()==0) { // 책 이름으로 책 정보를 받아오지 못한다면
				con.searchFail(name); // 실패 문 출력
			} else { // 책 이름과 동일한 책이 존재한다면
				con.show(list); // 콘솔 - 책 정보 출력
				//if(list.size()>1) {
					book = con.buyChoice("구매를", sc, list);				
				//} 
				bookResult = con.buy(sc, book); // 콘솔 - 책 객체를 콘솔롤 보내 책 구매 메소드 실행 > collection으로 받음
				if (bookResult == null) {
					if(buyList.size() == 0) {break;}
					else {choice = 2;}
				} else {
					buyList.add(bookResult);
					
					choice = con.buyContinue(sc);
				}
			}
		} while (choice == 1); // 계속 구매를 누르는 한 반복!

		if (choice == 2) {
			boolean isBuy = bbser.buyBook(buyList); // service에 list를 보냄 > DB 수정 후 변경이 완료되면 true / 아니면 false
			if (bookResult == null) {
				if(buyList.size() == 0) {}
				else {con.buySuccess("구매", buyList);}
			} else if (isBuy == false) { // DB 변경 실패 _ 책 구매 실패
				con.buyFail(); // 콘솔 - 실패 문구 출력
			} else {
				con.buySuccess("구매", buyList); // 콘솔 - 성공 문구 출력
			}
		}
	}
}
