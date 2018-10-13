package book.member.svc;

import java.util.ArrayList;

import book.member.dao.BookDAO;
import book.member.dto.Book;

/* Action���� å ���� �޾ƿ���.
   å ����, ���ż��� DAO�� �����ϱ�
   
   DAO ó�� ����� action ���� ����
   [���� ��� + ���� �Է� ���]
  */
public class BookBuyService {
	public ArrayList<Book> getBook(String name) { // å �������� ���� �������� �޼���
		BookDAO dao = new BookDAO(); // SQL�� ����
		ArrayList<Book> list = dao.selectOnebook(name); // DB���� �Ѱ��� å ������ �޾ƿ�
		return list;
	}

	public boolean buyBook(ArrayList<Book> buyList) { // å ���� �޼���
		int updateCount = 0;
		BookDAO dao = new BookDAO(); //DB - sql ���� ����
		updateCount = dao.buyBook(buyList); // �ܼ� - action�� ���� �Ѱܹ��� list�� DB �ݿ� �޼ҵ�� ���� > ������Ʈ �Ϸ� �� ����� != 0
		
		if(updateCount == 0) { // DB �ݿ� ���н� false ����
			return false;
		}else { // DB �ݿ� ������ true ���� >> action����
			return true;
		}
		
	}
}
