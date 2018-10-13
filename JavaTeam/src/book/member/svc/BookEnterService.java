package book.member.svc;

import book.member.dao.BookDAO;
import book.member.dto.Book;

public class BookEnterService {
	public boolean Enterbook(Book book) {
		int check;
		
		BookDAO dao = new BookDAO();
		check = dao.Enterbook(book);
		
		if(check > 0)
			return true;
		else
			return false;
	}

}
