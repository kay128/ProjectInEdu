package book.member.svc;

import java.util.ArrayList;

import book.member.dto.Book;
import book.member.dao.BookDAO;
import book.member.dto.Book;

public class BookRefundService {


	public boolean refundBook(Book book) {
		int check;
		
		BookDAO dao = new BookDAO();
		check = dao.RefundBook(book);
		
		if(check > 0)
			return true;
		else
			return false;
	}
}