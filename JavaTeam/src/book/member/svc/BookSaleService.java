package book.member.svc;

import java.util.ArrayList;

import book.member.dao.BookDAO;
import book.member.dto.Book;

/*
*/

public class BookSaleService {

	public ArrayList<Book> saleBook() {
		ArrayList<Book> list = null;
		
		BookDAO dao = new BookDAO();
		list = dao.saleBook();
		
		return list;
	}

}
