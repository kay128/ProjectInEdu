package book.member.svc;

import java.util.ArrayList;

import book.member.dao.BookDAO;
import book.member.dto.Book;

public class MoneyModifyService {

	public ArrayList<Book> getBooklist(String name) {
		//Book oldBook=null;
		ArrayList<Book> list =null;
		BookDAO dao=new BookDAO();
		list= dao.selectOnebook(name);
		
		return list;
	}

	public static boolean update(String name, Book updateBook) {
		BookDAO dao=new BookDAO();
		int updateCount =dao.updateBook(name, updateBook);
		
		if(updateCount>0){
			return true;
		}else{
			return false;
		}
		
	}

}
