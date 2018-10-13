package book.member.action;

import java.util.ArrayList;
import java.util.Scanner;

import book.member.dto.Book;
import book.member.svc.BookBuyService;
import book.member.svc.BookRecommendService;
import book.member.util.ConsoleUtils;

public class BookRecommendAction implements Action {

	@Override
	public void execute(Scanner sc) throws Exception {
		BookRecommendService recommendervice =new BookRecommendService();
		
		ArrayList<Book> list =recommendervice.allcount(); //DB �� ��� ������ �޾ƿͼ� arraylist �� ����
		ArrayList<Book> buy_list = new ArrayList<Book>();
		
		ConsoleUtils cu=new ConsoleUtils();
		
		if(list !=null) {//list �� null �ΰ��� db�� �����Ͱ� ���ų� db���� ������ �������� ���� ������ ��� 
			Book book=cu.showlistSuccess(list,sc,"��õ");//��õ���� ���
			
			if(book!=null){
				buy_list.add(book);
				BookBuyService buy_ser=new BookBuyService();
				buy_ser.buyBook(buy_list);
			}
		}else {
			cu.showrecommendFail();
		}

	}

}
