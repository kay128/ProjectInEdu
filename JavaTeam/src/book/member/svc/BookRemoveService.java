package book.member.svc;

import book.member.dao.BookDAO;
import book.member.dto.Book;

public class BookRemoveService {
	
	BookDAO dao = new BookDAO();
	
	public boolean removeBook(Book dto) {
		
		int check = dao.removeBook(dto);
		
		if(check > 0)
			return true;
		else
			return false;
	}
}
