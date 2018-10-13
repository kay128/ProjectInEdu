package book.member.action;

import java.util.ArrayList;
import java.util.Scanner;

import book.member.dto.Book;
import book.member.svc.BookBuyService;
import book.member.svc.BookRecommendService;
import book.member.util.ConsoleUtils;

public class BookRecommendAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		BookRecommendService recommendervice =new BookRecommendService();
		
		ArrayList<Book> list =recommendervice.allcount(); //DB 의 모든 정보를 받아와서 arraylist 에 저장
		ArrayList<Book> buy_list = new ArrayList<Book>();
		
		ConsoleUtils cu=new ConsoleUtils();
		
		if(list !=null) {//list 가 null 인경우는 db에 데이터가 없거나 db에서 데이저 가져오는 것을 실패한 경우 
			Book book=cu.showlistSuccess(list,sc,"추천");//추천도서 출력
			
			if(book!=null){
				buy_list.add(book);
				BookBuyService buy_ser=new BookBuyService();
				buy_ser.buyBook(buy_list);
			}
		}else {
			cu.showrecommendFail();
		}

	}

}
