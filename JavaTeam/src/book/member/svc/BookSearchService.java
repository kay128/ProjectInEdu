package book.member.svc;

import java.util.ArrayList;

import book.member.dao.BookDAO;
import book.member.dto.Book;


public class BookSearchService {

	public ArrayList<Book> getBook(String name) {
		ArrayList<Book> list = null;
		
		BookDAO dao = new BookDAO();
		list = dao.selectOnebook(name);
		
		return list;
	}


}
