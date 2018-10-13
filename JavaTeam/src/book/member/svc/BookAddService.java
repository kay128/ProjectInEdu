package book.member.svc;

import java.util.ArrayList;

import book.member.dao.BookDAO;
import book.member.dto.Book;

public class BookAddService {

	public boolean addBook(Book newBook) {
		int check;//등록된 책이있는지 확인하기위함
		BookDAO dao=new BookDAO();// DAO 클레스에 접속
		
		//DAO클래스에 있는 InsertBook 메소드에 newbook 삽입
		check = dao.inserBook(newBook); 
		
		//책이 check 1개 이상이면 true, 아니면 false
		if(check>0) {
			return true;
		}else {
			return false;
		}
	}
	
	public Book serch(String name) {
		Book book = null;
		
		BookDAO dao = new BookDAO();
		book = dao.searchbook(name);
		
		return book;
	}

}
