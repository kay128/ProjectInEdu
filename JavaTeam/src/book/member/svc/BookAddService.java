package book.member.svc;

import java.util.ArrayList;

import book.member.dao.BookDAO;
import book.member.dto.Book;

public class BookAddService {

	public boolean addBook(Book newBook) {
		int check;//��ϵ� å���ִ��� Ȯ���ϱ�����
		BookDAO dao=new BookDAO();// DAO Ŭ������ ����
		
		//DAOŬ������ �ִ� InsertBook �޼ҵ忡 newbook ����
		check = dao.inserBook(newBook); 
		
		//å�� check 1�� �̻��̸� true, �ƴϸ� false
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
