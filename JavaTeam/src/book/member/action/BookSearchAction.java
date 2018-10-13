package book.member.action;

import java.util.ArrayList;
import java.util.Scanner;
import book.member.dto.Book;
import book.member.svc.BookSearchService;
import book.member.util.ConsoleUtils;


public class BookSearchAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		//Book book = null;
		ArrayList<Book> list =null;
		ConsoleUtils cu = new ConsoleUtils();
		String name = cu.getName("°Ë»ö", sc);
		
		BookSearchService searchservice = new BookSearchService();
		list = searchservice.getBook(name);
		
		if(list == null) {
			cu.showMemberFail(name);
		}else {
			cu.show(list);
		}
		
	}

}
