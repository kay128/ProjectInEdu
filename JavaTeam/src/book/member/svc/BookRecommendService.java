package book.member.svc;

import java.util.ArrayList;

import book.member.dao.BookDAO;
import book.member.dto.Book;

public class BookRecommendService {
	public ArrayList<Book> allcount() {
		ArrayList<Book> list =null;//��� ������  �������� ���ؼ�
		
		BookDAO dao=new BookDAO();//������ ó�� �ϴ� Ŭ����
		list=dao.selecRecommend();//�Ǹŷ��� ������ ������ �����Ͽ� �����͸� ������������ Ŀ���� ó�� �Լ�
	
		return list;
	}
}
