package book.member.svc;

import java.util.ArrayList;

import book.member.dao.BookDAO;
import book.member.dto.Book;

public class TotalMoneyService {

	public ArrayList<Book> allMoney() {
		ArrayList<Book> list =null;//��ü db �����͸� ���� �ð� �̱� ������ arrylist ����
		
		BookDAO dao=new BookDAO();//������ ó�� �ϴ� Ŭ����
		list=dao.selectAllMember();//��� ������ �� �������� ������ ó�� �ϴ� �Լ���
	
		return list;
	}

}
